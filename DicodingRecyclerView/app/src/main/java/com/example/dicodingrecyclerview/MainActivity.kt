package com.example.dicodingrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicodingrecyclerview.adapters.CardViewHeroAdapter
import com.example.dicodingrecyclerview.adapters.GridHeroAdapter
import com.example.dicodingrecyclerview.adapters.HeroAdapter
import com.example.dicodingrecyclerview.models.HeroModels
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list = ArrayList<HeroModels>()
    private var title = "List View"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = title

        list.addAll(getListHero())
        rv_listHero.setHasFixedSize(true)
        setRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setRecyclerView() {
        rv_listHero.layoutManager = LinearLayoutManager(this)
        val heroAdapter = HeroAdapter(list)
        rv_listHero.adapter = heroAdapter

        heroAdapter.setOnItemCallback(object : HeroAdapter.OnItemClickCallBack {
            override fun onItemClicked(data: HeroModels) {
                showSelectedHero(data)
            }
        })
    }

    private fun setGridView() {
        rv_listHero.layoutManager = GridLayoutManager(this, 2)
        rv_listHero.adapter = GridHeroAdapter(list)
    }

    private fun setCardView() {
        rv_listHero.layoutManager = LinearLayoutManager(this)
        rv_listHero.adapter = CardViewHeroAdapter(list)
    }

    private fun setMode(mode: Int) {
        when(mode){
            R.id.action_list -> {
                setRecyclerView()
                title = "ListView"
            }
            R.id.action_grid -> {
                setGridView()
                title = "GridView"
            }
            R.id.action_cardview -> {
                setCardView()
                title = "CardView"
            }
        }
        supportActionBar?.title = title
    }

    private fun showSelectedHero(hero: HeroModels) {
        Toast.makeText(this, "Kamu memilih ${hero.name}", Toast.LENGTH_SHORT).show()
    }

    private fun getListHero(): ArrayList<HeroModels> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val listHero = ArrayList<HeroModels>()
        for(position in dataName.indices) {
            val hero = HeroModels(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listHero.add(hero)
        }
        return listHero
    }
}


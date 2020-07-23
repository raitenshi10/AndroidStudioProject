package com.example.dicodingunittestingdanmvvmdesignpattern

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.mock

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel
    private var dummyLength = 17.0
    private var dummyWidth = 10.0
    private var dummyHeight = 11.0
    private var dummyVolume = 1870.0
    private var dummySurface = 934.0
    private var dummyCircumference = 152.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }


    @Test
    fun getCirumference() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight)
        val circumference = mainViewModel.getCirumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun getSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyHeight, dummyWidth, dummyLength)
        val surface = mainViewModel.getSurfaceArea()
        assertEquals(dummySurface, surface, 0.0001)
    }

    @Test
    fun getVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun save() {
    }
}
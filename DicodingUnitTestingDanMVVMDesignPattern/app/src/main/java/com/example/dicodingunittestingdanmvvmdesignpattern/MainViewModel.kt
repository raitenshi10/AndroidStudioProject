package com.example.dicodingunittestingdanmvvmdesignpattern

class MainViewModel(private val cuboidModel: CuboidModel) {
    fun getCirumference(): Double = cuboidModel.getCircumference()
    fun getSurfaceArea(): Double = cuboidModel.getSurfaceArea()
    fun getVolume(): Double = cuboidModel.getVoluem()
    fun save(l: Double, w: Double, h: Double) {
        cuboidModel.save(w, l, h)
    }
}
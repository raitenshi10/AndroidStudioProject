package com.example.dicodingunittestingdanmvvmdesignpattern

class CuboidModel(var length: Double = 0.0, var width: Double = 0.0, var height: Double = 0.0) {

    fun getVoluem() = length*width*height

    fun getSurfaceArea(): Double {
        val wl = width*length
        val wh = width*height
        val lh = length*height
        return 2*(wl+wh+lh)
    }

    fun getCircumference(): Double {
        return 4*(width+length+height)
    }

    fun save(width: Double, length: Double, height: Double){
        this.width = width
        this.length = length
        this.height = height
    }
}
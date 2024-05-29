package com.example.amphibiansapp.fake

import com.example.amphibiansapp.data.Model.Amphibian

object FakeDataSource {


    const val idOne = "img1"
    const val idTwo = "img2"
    const val idThree = "img3"
    const val imgOne = "img1.1"
    const val imgTwo = "img1.2"
    const val imgThree = "img1.3"
    const val descriptionOne = "description1"
    const val descriptionTwo = "description2"
    const val descriptionThree = "description3"
    const val nameOne = "name1"
    const val nameTwo = "name2"
    const val nameThree = "name3"



    val amphibianList = listOf(
        Amphibian(nameOne,imgOne,descriptionOne),
        Amphibian(nameTwo,imgTwo,descriptionTwo),
        Amphibian(nameThree,imgThree,descriptionThree)
    )

}
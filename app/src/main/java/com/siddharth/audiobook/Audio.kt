package com.siddharth.audiobook

data class Audio(val results : List<Results>){

}
data class Results(val artistName : String, val trackName : String, val description : String, val artworkUrl60 : String, val primaryGenreName :  String){

}
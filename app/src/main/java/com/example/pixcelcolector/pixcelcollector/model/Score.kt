package com.example.pixcelcolector.pixcelcollector.model

import android.content.Context
import java.security.AccessControlContext
import java.util.*

class Score
{
    var id:Int = 0
    var point:Int = 0
    var username:String=""

    constructor(score:Int, username:String)
    {
        this.point = score
        this.username = username
    }

    constructor(){
        point = 0
    }

    fun getPoint(context: Context, username: String)
    {
        var db = DataBaseHandler(context)
        var listScore : MutableList<Score> = ArrayList()
        listScore = db.selectScoreListByUsername(username)
        db.close()
    }

    fun insertUsername(context:Context, username: String, point: Int)
    {
        var db = DataBaseHandler(context)
        var point = Score(point, username)
        db.insertData(point)
        db.close()
    }

    fun getFirstScore(context: Context)
    {
        var db = DataBaseHandler(context)
    }

    fun updateScore(valeur:Int)
    {
        point = point + valeur
    }
}

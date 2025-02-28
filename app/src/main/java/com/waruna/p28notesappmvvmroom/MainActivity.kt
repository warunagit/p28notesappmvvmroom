package com.waruna.p28notesappmvvmroom

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // NotesApp contains all of:
    // LiveView,DataBinding,MVVM,ROOM,Navigation

    //1-add dependencies
    //2-add NavHostFragment(FragmentContainerView)->
    // NavGraph to activity_main.xml
    //3-add destination fragments to nav_graph.xml
    //4-add note_layout.xml
    //5-create menu files


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }
}
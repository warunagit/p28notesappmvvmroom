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
    //3-add destinations to nav_graph.xml
    //4-change FrameLayouts to ConstraintLayouts
    //5-add FloatingActionButton to fragment_home


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }
}
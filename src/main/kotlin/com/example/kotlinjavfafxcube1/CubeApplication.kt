package com.example.kotlinjavfafxcube1

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class CubeApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(
            CubeApplication::
            class.java.getResource("controls-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 300.0)
        stage.title = "3D Controls"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(CubeApplication::class.java)
}
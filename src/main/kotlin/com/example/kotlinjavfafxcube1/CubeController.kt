package com.example.kotlinjavfafxcube1

import javafx.scene.*
import javafx.scene.control.Slider
import javafx.scene.paint.Color
import javafx.scene.shape.Box
import javafx.scene.transform.Rotate
import javafx.stage.Stage

class CubeController {
    lateinit var sldX1: Slider
    lateinit var sldY1: Slider
    lateinit var sldZ1: Slider

    lateinit var sldX2: Slider
    lateinit var sldY2: Slider
    lateinit var sldZ2: Slider

    lateinit var sldX3: Slider
    lateinit var sldY3: Slider
    lateinit var sldZ3: Slider

    lateinit var sldX4: Slider
    lateinit var sldY4: Slider
    lateinit var sldZ4: Slider

    fun initialize() {
        // Create a 3D Box
        val box = Box(200.0, 200.0, 200.0)

        // Create a Point Light
        val light = PointLight(Color.CYAN)

        // Create a Group
        val group = Group()
        group.children.addAll(box, light)

        // Create a Camera
        val fixedEyeAtCameraZero = false
        val camera = PerspectiveCamera(fixedEyeAtCameraZero)
        camera.translateX = 150.0
        camera.translateY = -100.0
        camera.translateZ = 250.0

        // Create a scene
        val scene = Scene(group, 1000.0, 1000.0)
        scene.camera = camera

        // Create a stage
        val stage = Stage()
        stage.title = "Drawing a Box"
        stage.scene = scene
        stage.show()

        // Bind the 1st set of sliders to the size of the box
        box.scaleXProperty().bind(sldX1.valueProperty())
        box.scaleYProperty().bind(sldY1.valueProperty())
        box.scaleZProperty().bind(sldZ1.valueProperty())

        // Bind the 2nd set of sliders to the box position
        box.translateXProperty().bind(sldX2.valueProperty())
        box.translateYProperty().bind(sldY2.valueProperty())
        box.translateZProperty().bind(sldZ2.valueProperty())

        // Bind the 3rd set of sliders to the light position
        light.translateXProperty().bind(sldX3.valueProperty())
        light.translateYProperty().bind(sldY3.valueProperty())
        light.translateZProperty().bind(sldZ3.valueProperty())

        // Add listeners to the 4th set of sliders to rotate box
        sldX4.valueProperty().addListener { _ ->
            group.rotationAxis = Rotate.X_AXIS
            group.rotate = sldX4.value
        }

        sldY4.valueProperty().addListener { _ ->
            group.rotationAxis = Rotate.Y_AXIS
            group.rotate = sldY4.value
        }

        sldZ4.valueProperty().addListener { _ ->
            group.rotationAxis = Rotate.Z_AXIS
            group.rotate = sldZ4.value
        }
    }
}
package com.example.myawesomemod.ui

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import net.torvald.terrarum.App
import net.torvald.terrarum.langpack.Lang
import net.torvald.terrarum.modulebasegame.TerrarumIngame
import net.torvald.terrarum.ui.Toolkit
import net.torvald.terrarum.ui.UICanvas
import kotlin.math.PI
import kotlin.math.roundToInt
import kotlin.math.sin

/**
 * Created by minjaesong on 2024-01-10.
 */
class UIHelloWorld(private val ingame: TerrarumIngame) : UICanvas() {
    override var height = 24
    override var width = 120

    private val animLength = 2f
    private var animTimer = 0f

    private var xoff = 0f

    init {
        setAsAlwaysVisible()
    }

    override fun renderUI(frameDelta: Float, batch: SpriteBatch, camera: OrthographicCamera) {
        xoff = (sin(animTimer * PI / animLength) * 120).toFloat()

        Toolkit.drawBaloon(batch, 0f, 0f, width.toFloat(), height.toFloat())
        Toolkit.drawTextCentered(batch, App.fontGame, Lang["MYAWESOME_GREET"], width, 0, 0)

        animTimer += frameDelta
        while (animTimer > animLength * 2) {
            animTimer -= animLength * 2
        }
    }

    override fun updateUI(delta: Float) {
        posX = ((Toolkit.drawWidth - width) / 2 + xoff).roundToInt()
        posY = (App.scr.height - App.scr.tvSafeGraphicsHeight - height)
    }

    override fun dispose() {
    }
}
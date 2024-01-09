package com.example.myawesomemod

import com.example.myawesomemod.ui.UIHelloWorld
import net.torvald.terrarum.ModMgr
import net.torvald.terrarum.ModuleEntryPoint
import net.torvald.terrarum.modulebasegame.TerrarumIngame

/**
 * Created by minjaesong on 2024-01-10.
 */
class EntryPoint : ModuleEntryPoint() {
    override fun invoke() {
        ModMgr.GameExtraGuiLoader.register { ingame: TerrarumIngame ->  UIHelloWorld(ingame) }
    }

    override fun dispose() {
    }
}
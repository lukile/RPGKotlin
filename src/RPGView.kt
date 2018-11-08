interface RPGView {
    fun showWelcomeMessage()

    fun getPseudoAnswer(): String?

    fun askToStartDungeon(): String

    fun askChooseWeapon(): String
}
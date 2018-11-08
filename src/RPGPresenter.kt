class RPGPresenter {
    private val view: RPGConsole = RPGConsole(this)

    companion object {
        const val YES_ANSWER = "Y"
        const val NO_ANSWER = "N"
    }

    fun start() {
        view.showWelcomeMessage()

        var playerName = view.getPseudoAnswer()

        view.askToStartDungeon()

        var weapon = view.askChooseWeapon()

        val player = Player(playerName!!, 120, weapon)

    }
}


class RPGConsole(rpgPresenter: RPGPresenter) : RPGView {
    override fun getPseudoAnswer(): String? {
        var playerName: String? = readLine()
        playerName = playerName ?: "Defaut"

        println("$playerName.... What a weird name...")
        return playerName
    }

    override fun showWelcomeMessage() {
        println("""Welcome stranger !
        |What's your name ?""".trimMargin("|"))
    }

    override fun askToStartDungeon(): String {
        println("""Do you want to enter inside dungeon ?
        |${ RPGPresenter.YES_ANSWER }-> to begin
        |${ RPGPresenter.NO_ANSWER }-> to leave""".trimMargin())

        return giveChoice()
    }

    private fun giveChoice(): String {
        val answer = readLine()

        when (answer?.toUpperCase()) {
            RPGPresenter.YES_ANSWER -> println("Let's go stranger")
            RPGPresenter.NO_ANSWER -> println("See ya stranger...")
            else -> askToStartDungeon()
        }

        if (answer?.toUpperCase() == RPGPresenter.YES_ANSWER) {
            askChooseWeapon()
        }

        return readLine()!!
    }

    override fun askChooseWeapon(): String {
        val weapon = getAllWeaponNames()
        var response: Boolean
        var answer: String?
        var damage: Int

        do{
            chooseWeapon(weapon)

            answer = readLine()
            response = RPGWeapon.contains(answer!!.toUpperCase())
            damage = RPGWeapon.displayCarac(answer.toUpperCase())

        } while (!response)

        println("You have chosen ${answer?.toUpperCase()} and you'll make $damage damages")
        return answer!!
    }

    private inline fun getAllWeaponNames(): String {
        return enumValues<RPGWeapon>().joinToString { it.toString() }
    }

    private fun chooseWeapon(weapon: String) {
        println("""Now... You have to choose how you'll beat terrible demons
                |Select which weapon you prefer
                |${weapon.toLowerCase()}""".trimMargin("|"))
    }

}
enum class RPGWeapon(val type: String, val damage: Int) {
    SWORD("Sword", 12),
    AXE("Axe", 15),
    BOW("bow", 10);

    override fun toString(): String {
        return type
    }

    companion object {
        fun contains(type: String): Boolean {
            return values().any { it -> it.name == type.toUpperCase() }
        }

        fun displayCarac(type: String) = valueOf(type).damage
    }
}
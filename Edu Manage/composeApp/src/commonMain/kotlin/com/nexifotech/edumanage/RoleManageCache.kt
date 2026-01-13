package com.nexifotech.edumanage

import com.russhwolf.settings.Settings

object RoleManageCache {
    private val settings = Settings()
    private const val KEY_ROLE = "user_role"

    fun saveRole(role: String) {
        settings.putString(KEY_ROLE, role)
    }
    fun getRole(): String? {
        return settings.getStringOrNull(KEY_ROLE)
    }
    fun clearRole() {
        settings.clear()
    }
}
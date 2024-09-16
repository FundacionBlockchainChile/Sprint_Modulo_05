package com.example.sprint_modulo_05.data

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.sprint_modulo_05.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import com.google.gson.Gson
import java.io.IOException

// Delegado de DataStore (se configura una sola vez por contexto)
private val Context.dataStore by preferencesDataStore(name = "cart_prefs")

class DataStoreManager(context: Context) {
    private val dataStore = context.dataStore

    companion object {
        val CART_KEY = stringPreferencesKey("cart_products")
    }

    suspend fun saveCartProducts(cart: List<Product>) {
        dataStore.edit { preferences ->
            val json = Gson().toJson(cart)
            preferences[CART_KEY] = json
        }
    }

    val cartProducts: Flow<List<Product>> = dataStore.data
        .catch { exception ->
            // Si ocurre algún error en la lectura del DataStore, lo manejamos
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val json = preferences[CART_KEY] ?: return@map emptyList<Product>()
            Gson().fromJson(json, object : com.google.gson.reflect.TypeToken<List<Product>>() {}.type)
        }
}

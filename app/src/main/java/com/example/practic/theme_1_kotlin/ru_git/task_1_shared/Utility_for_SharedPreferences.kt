package com.example.practic.theme_1_kotlin.ru_git.task_1_shared

import android.content.SharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//  для сохранения данных
fun SharedPreferences.saveAsync(
    key: String,
    value: Any?,
    useCommit: Boolean = false,
    onSuccess: (() -> Unit)? = null,
    onError: ((Exception) -> Unit)? = null
) {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val editor = edit()
            when (value) {
                is String -> editor.putString(key, value)
                is Int -> editor.putInt(key, value)
                is Boolean -> editor.putBoolean(key, value)
                is Float -> editor.putFloat(key, value)
                is Long -> editor.putLong(key, value)
                null -> editor.remove(key)
                else -> throw IllegalArgumentException("Unsupported value type: ${value::class.java}")
            }

            if (useCommit) {
                editor.commit()
            } else {
                editor.apply()
            }

            withContext(Dispatchers.Main) {
                onSuccess?.invoke()
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                onError?.invoke(e)
            }
        }
    }
}

// для загрузки данных
fun SharedPreferences.loadAsync(
    key: String,
    defaultValue: Any? = null,
    onResult: (result: Any?) -> Unit,
    onError: ((Exception) -> Unit)? = null
) {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val result = when (defaultValue) {
                is String -> getString(key, defaultValue)
                is Int -> getInt(key, defaultValue)
                is Boolean -> getBoolean(key, defaultValue)
                is Float -> getFloat(key, defaultValue)
                is Long -> getLong(key, defaultValue)
                null -> getString(key, null)
                else -> throw IllegalArgumentException("Unsupported default value type: ${defaultValue::class.java}")
            }

            withContext(Dispatchers.Main) {
                onResult(result)
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                onError?.invoke(e)
            }
        }
    }
}
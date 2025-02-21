package com.example.practic.themes.sdk_4.interview_questions.content_provider

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri

class NotesProvider : ContentProvider() {

    // Это будет наша "база данных" (простой список)
    private val notes = mutableListOf("First Note", "Second Note", "Third Note")

    override fun onCreate(): Boolean {
        // Инициализация (обычно тут открывается база данных или подключение)
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor {
        // Возвращаем данные из базы данных или файла
        val cursor = MatrixCursor(arrayOf("note"))
        cursor.addRow(arrayOf("First Note"))
        cursor.addRow(arrayOf("Second Note"))
        return cursor
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        // Добавляем новую заметку
        val newNote = values?.getAsString("note") ?: return null
        notes.add(newNote)
        return Uri.parse("content://com.example.practic.themes.sdk_4.interview_questions.content_provider.notesprovider/notes/$newNote")

    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        // В этом примере обновление не поддерживаем
        return 0
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        // В этом примере удаление не поддерживаем
        return 0
    }

    override fun getType(uri: Uri): String? {
        // Указываем MIME-тип для данных
        return "vnd.android.cursor.dir/vnd.example.notes"
    }
}

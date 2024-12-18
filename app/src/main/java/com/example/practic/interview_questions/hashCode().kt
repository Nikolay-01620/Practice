package com.example.practic.interview_questions

/*
public int hashCode() {

    String var10000 = this.original;
    int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
    String var10001 = this.translate;
    return var1 + (var10001 != null ? var10001.hashCode() : 0);

     используется техника комбинирования хеш-кодов полей с использованием множителя 31

}*/



data class Person(val name: String, val age: Int) {
    override fun hashCode(): Int {
        var result = name.hashCode()  // Получаем хеш-код для name
        result = 31 * result + age    // Умножаем на 31 и добавляем хеш-код для age
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }
}


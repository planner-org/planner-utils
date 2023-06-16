package com.projects.planner.utils;

public final class Checker {
    private Checker() {
        throw new IllegalStateException("Util class can't have an instance");
    }

    /**
     * Проверка id объекта на null и 0. Id должен быть больше нуля, иначе исключение.
     * @param id - идентификатор
     */
    public static void idIsNullOrZero(Long id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Missing param: Id must not be null or Zero");
        }
    }

    /**
     * Проверка на отсутствие id объекта. Используется при добавлении новой записи (id должен быть null, иначе инсключение).
     * @param id - идентификатор
     */
    public static void idNotNull(Long id) {
        if (id != null) {
            throw new IllegalArgumentException("Missing param: Id must be null");
        }
    }

    /**
     * Проверка параметра. Если null или пустой - бросаем исключение.
     * @param param - проверяемый параметр
     * @param fieldName - имя параметра
     */
    public static void paramIsNullOrEmpty(String param, String fieldName) {
        if (param == null || param.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing param: " + fieldName + " must not be null or empty");
        }
    }

}

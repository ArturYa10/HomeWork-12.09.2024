import java.util.HashMap;
import java.util.Map;

public class SQLQueryBuilder {

    public static String buildQuery(Map<String, Object> params) {
        // Инициализация StringBuilder для построения SQL запроса
        StringBuilder query = new StringBuilder("SELECT * FROM cars WHERE ");
        boolean firstCondition = true;

        // Проход по параметрам
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            // Пропускаем параметры с null значением
            if (value != null) {
                // Если это не первая условие, добавляем "AND"
                if (!firstCondition) {
                    query.append(" AND ");
                }

                // Добавляем условие в зависимости от типа значения
                if (value instanceof String) {
                    query.append(key).append(" = '").append(value).append("'");
                } else if (value instanceof Boolean) {
                    query.append(key).append(" = ").append(value);  // Логические значения без кавычек
                } else {
                    query.append(key).append(" = ").append(value);  // Числовые значения без кавычек
                }

                // После первого условия меняем флаг
                firstCondition = false;
            }
        }

        // Если не было ни одного условия
        if (firstCondition) {
            return "SELECT * FROM cars";  // Если нет условий, вернем запрос без WHERE
        }

        return query.toString();
    }

    public static void main(String[] args) {
        // Пример параметров
        Map<String, Object> params = new HashMap<>();
        params.put("model", "V-60");
        params.put("country", "Germany");
        params.put("city", "Berlin");
        params.put("year", null);
        params.put("active", true);

        // Формируем запрос
        String query = buildQuery(params);
        System.out.println(query);

        // Другой пример
        Map<String, Object> params2 = new HashMap<>();
        params2.put("id", 1);
        params2.put("country", null);
        params2.put("city", "Helsinki");
        params2.put("year", null);

        String query2 = buildQuery(params2);
        System.out.println(query2);
    }
}

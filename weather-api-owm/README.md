# Open Weather Map Module

Example:

        OpenWeatherMap openWeatherMap = new OpenWeatherMapTemplate(YOUR API KEY);
        HistoricalConditionsOperations hco = openWeatherMap.historicalConditionsOperations();
        HistoricalConditions<City> historicalConditions = hco.conditionsNearCityByIdAtTime("5381421", new Date(1414986653*1000));

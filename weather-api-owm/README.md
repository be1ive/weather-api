# Open Weather Map Module

Example:
        OpenWeatherMap openWeatherMap = new OpenWeatherMapTemplate("dab15b81ad001128f8bd2621c5605b1c");
        HistoricalConditionsOperations hco = openWeatherMap.historicalConditionsOperations();
        HistoricalConditions<City> historicalConditions = hco.conditionsNearCityByIdAtTime("5381421",
                new Date(1414986653*1000));

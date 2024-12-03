USE currency_db;

-- Retrieving all of the currencies
SELECT * FROM currencies;

-- Retrieve the currency with the abbreviation EUR
SELECT * FROM currencies WHERE abbreviation = 'EUR';

-- A query that retrieves the total number of currencies in the database
SELECT COUNT(*) AS currency_count FROM currencies;

-- Currency with the highest exchange rate
SELECT * FROM currencies
ORDER BY exchange_rate DESC
LIMIT 1;
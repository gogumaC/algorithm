SELECT P.PRODUCT_ID,PRODUCT_NAME,SUM(AMOUNT)*PRICE AS TOTAL_SALES
FROM FOOD_PRODUCT P JOIN FOOD_ORDER O ON P.PRODUCT_ID=O.PRODUCT_ID
WHERE YEAR(O.PRODUCE_DATE)="2022" AND MONTH(O.PRODUCE_DATE)="5"
GROUP BY O.PRODUCT_ID
ORDER BY TOTAL_SALES DESC,P.PRODUCT_ID;
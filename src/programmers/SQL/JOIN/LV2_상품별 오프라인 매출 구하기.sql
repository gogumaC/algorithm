SELECT PRODUCT.PRODUCT_CODE,SUM(SALES_AMOUNT)*PRICE AS SALES
FROM OFFLINE_SALE
JOIN PRODUCT ON PRODUCT.PRODUCT_ID=OFFLINE_SALE.PRODUCT_ID
GROUP BY OFFLINE_SALE.PRODUCT_ID
ORDER BY SALES DESC,PRODUCT.PRODUCT_CODE;
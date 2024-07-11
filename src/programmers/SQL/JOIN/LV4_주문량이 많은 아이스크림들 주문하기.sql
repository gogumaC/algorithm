SELECT FH.FLAVOR
FROM FIRST_HALF FH JOIN JULY J ON FH.FLAVOR=J.FLAVOR
GROUP BY J.FLAVOR
ORDER BY FH.TOTAL_ORDER+SUM(J.TOTAL_ORDER) DESC
LIMIT 3
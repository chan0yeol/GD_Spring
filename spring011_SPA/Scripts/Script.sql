-- 로그인 
SELECT ID, NAME, AUTH, JOINDATE  
	FROM BOARDUSER
	WHERE ID='A001' AND PASSWORD = 'A001'
 	AND ENABLE = 'Y';


-- 게시글 전체조회 
SELECT *
	FROM (SELECT SEQ, ID,
			LPAD(' ',6*5*"DEPTH"+1,'&nbsp;')||
			CASE 
				WHEN "DEPTH" > 0 THEN '<img src="./img/reply.png">'
			END || TITLE AS TITLE,
			CONTENT, "REF", STEP,
			"DEPTH", REGDATE, DELFLAG,
			ROW_NUMBER() OVER(ORDER BY REF DESC, STEP) RN
			FROM ANSWERBOARD a)
	WHERE RN BETWEEN 1 AND 10

UPDATE ANSWERBOARD
		  SET TITLE = 'assd', CONTENT = 'asssd'
		  WHERE SEQ = '213';	
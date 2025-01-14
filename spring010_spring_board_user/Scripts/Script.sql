SELECT SEQ, ID, TITLE,
	CONTENT, "REF", STEP,
	"DEPTH", REGDATE, DELFLAG
	FROM ANSWERBOARD a;
	
SELECT SEQ, ID,
	LPAD(' ',6*5*"DEPTH"+1,'&nbsp;')||
	CASE 
		WHEN "DEPTH" > 0 THEN '<img src="./img/reply.png">'
	END || TITLE AS TITLE,
	CONTENT, "REF", STEP,
	"DEPTH", REGDATE, DELFLAG
	FROM ANSWERBOARD a;

UPDATE ANSWERBOARD 
SET DELFLAG = 'Y'
WHERE DELFLAG ='N'
AND SEQ IN ('1','2','3');

SELECT NVL(MAX(SEQ),0)+1 FROM ANSWERBOARD a ; -- SEQ 값 
SELECT NVL(MAX(REF),0)+1 FROM ANSWERBOARD a; -- REF 값
INSERT INTO ANSWERBOARD 
		(SEQ, ID, TITLE,
		CONTENT, "REF", STEP,
		"DEPTH", REGDATE)
	VALUES ((SELECT NVL(MAX(SEQ),0)+1 FROM ANSWERBOARD),'A001','화요일 좋다',
	'행복한날', (SELECT NVL(MAX(REF),0)+1 FROM ANSWERBOARD a),0,0,CURRENT_DATE );

SELECT SEQ, ID, TITLE,
	CONTENT, "REF", STEP,
	"DEPTH", TO_CHAR(REGDATE,'YYYY-MM-DD HH:mi:ss'), DELFLAG
	FROM ANSWERBOARD
	WHERE SEQ = '30';
------------------------------------------------------------------------------------------------


---- 답글 
UPDATE ANSWERBOARD
SET STEP = STEP+1
WHERE REF = (SELECT REF FROM ANSWERBOARD WHERE SEQ = '30') 
AND STEP > (SELECT STEP FROM ANSWERBOARD WHERE SEQ = '30');

INSERT INTO ANSWERBOARD 
		(SEQ, ID, TITLE,
		CONTENT, "REF", STEP,
		"DEPTH", REGDATE)
	VALUES ((SELECT NVL(MAX(SEQ),0)+1 FROM ANSWERBOARD),'A001','정보초리기사',
		'문제다', (SELECT REF FROM ANSWERBOARD WHERE SEQ = '3'),
		(SELECT STEP FROM ANSWERBOARD WHERE SEQ = '3')+1,
		(SELECT "DEPTH" FROM ANSWERBOARD WHERE SEQ = '3')+1,CURRENT_DATE) ;
	
	
------- 회원(BoardUser)
SELECT ID, NAME, EMAIL, AUTH, JOINDATE
	FROM BOARDUSER b
	WHERE ID = 'A001' AND PASSWORD = 'A001';

SELECT COUNT(*) 
	FROM BOARDUSER b
	WHERE ID= 'A005';

SELECT 'A'||LPAD(MAX(SUBSTR(ID,4,1))+1,3,'0') FROM BOARDUSER b;

INSERT INTO BOARDUSER 
	VALUES((SELECT 'A'||LPAD(MAX(SUBSTR(ID,4,1))+1,3,'0') FROM BOARDUSER b), '화요일', 'A004', 'A004@aaa.com', 'U', 'Y', CURRENT_DATE);
SELECT 'A'||LPAD(MAX(SUBSTR(ID,4,1))+1,3,'0') FROM BOARDUSER b;
SELECT ID, NAME
	FROM BOARDUSER b
	WHERE AUTH = 'U';

SELECT ID, NAME, PASSWORD , EMAIL, AUTH, ENABLE , JOINDATE
	FROM BOARDUSER b;

SELECT ID, NAME
	FROM BOARDUSER
	WHERE AUTH = 'U' AND ID = 'A001'  ; 
SELECT ID, NAME
	FROM BOARDUSER
	WHERE AUTH = 'U' AND NAME = '햇빛'  ; 

SELECT ID
	FROM BOARDUSER b
	WHERE NAME = '햇빛' AND EMAIL = 'A001@naver.com';

---------- 복구
	SELECT SEQ, ID, TITLE,
		CONTENT, "REF", STEP,
		"DEPTH", TO_CHAR(REGDATE,'YYYY-MM-DD hh:mm:ss'), DELFLAG
		FROM ANSWERBOARD a
		WHERE DELFLAG = 'Y';

UPDATE ANSWERBOARD 
SET DELFLAG = 'N'
WHERE SEQ IN ('1','2','3');

	
	
	
	
	
	
	
	
--MemberDao.getMember(int page)//size������ �ѷ��ִ� ���� ������
SELECT * FROM MEMBERS;
SELECT * FROM (SELECT ROWNUM NUM, A.* FROM (SELECT * FROM MEMBERS ORDER BY REGDATE DESC)A)
WHERE NUM BETWEEN 11 AND 20;


# Schedulemanagement
스프링을 사용한 일정관리 앱 만들기 코드입니다.
일정관리(CRUD) 및 댓글 생성, 댓글 불러오기 등의 기능을 수행합니다.

## 핵심기능
>일정관리
- 일정생성
- 전체일정조회
- 선택일정조회
- 일정수정
- 일정삭제

>댓글관리
- 댓글생성

<br>

## ERD
<img width="952" height="270" alt="image" src="https://github.com/user-attachments/assets/4c50d838-318c-48b0-8a91-a6bae7e3e611" />

<br>

## API 명세서

### 일정 생성
```
Request
Method: `POST`

URL: /schedules

Content-Type: application/json

Body:
{
  “title”:”글의 제목입니다”,
  “contents”:”글의 내용입니다”,
  “name”:”이상민”,
  “password”:”qwer1234”
}
```
```
Response

Status Code: 201 Created

Body:
{
  "id":1,
  “title”:”글의 제목입니다”,
  “contents”:”글의 내용입니다”,
  “name”:”이상민”,
  "created":"2026-06-30",
  "updated":"2026-06-30"
}
```

<br>

### 일정 전체 조회
```
Request

Method: `GET`

URL:/schedules

Content-Type: `application/json`
```

```
Response

Status Code: 200 OK

Body:
[
  {
    "id":1,
    “title”:”글의 제목입니다”,
    “contents”:”글의 내용입니다”,
    “name”:”이상민”,
    "created":"2026-06-30",
    "updated":"2026-06-30"
  },
  {
    "id":2,
    “title”:”두번째 글”,
    “contents”:”두번째 글 내용”,
    “name”:”이순신”,
    "created":"2026-06-29",
    "updated":"2026-07-01"
  }
]
```

<br>

### 일정 단건 조회
```
Request

Method: `GET`

URL:/schedules/{id}

Status Code: `200 OK`
```

```
Response

Status Code: 200 OK

Body:
{
    "id":1,
    “title”:”글의 제목입니다”,
    “contents”:”글의 내용입니다”,
    “name”:”이상민”,
    "created":"2026-06-30",
    "updated":"2026-06-30",
    "comments":[
        {
          "commentID": 1,
          "commentContents":"첫번째 댓글",
          "name": "손흥민",
          "commentCreated":"2026-06-30",
        },
        {
          "commentID": 2,
          "commentContens":"두번째 댓글",
          "name": "홍명보",
          "commentCreated":"2026-06-30"
        }
    ]
}
```

<br>

### 일정수정
```
Request

Method: `PUT`

URL:/schedules/{id}

Content-Type: `application/json`


Body:
{
  "title": "수정된 제목입니다",
  "name": "홍길동",
  "password": "qwer1234"
}
```

```
Response

Status Code: 200 OK

Body:
{
  "id":1,
  “title”:”수정된 제목입니다.”,
  “contents”:”글의 내용입니다”,
  “name”:”홍길동”,
  "created":"2026-06-30",
  "updated":"2026-07-01"
}
```

<br>

### 일정삭제
```
Request

Method: `DELETE`

URL:/schedules/{id}

Content-Type: `application/json`

Body:
{
  "password":"qwer1234"
}
```
```
Response

Status Code: `204 No Content`
```
<br>

## 댓글관리
### 댓글생성
```
Request
Method: `POST`

URL: /comments

Content-Type: application/json

Body:
{
  “commentContents”:"첫번째 댓글입니다”,
  “commentName”:”손흥민”,
  “password”:”asdfasdf”,
}
```
```
Response

Status Code: 201 Created

Body:
{
  "commentId":1,
  “commentContents”:”첫번째 댓글입니다”,
  “commentName”:”손흥민”,
  "created":"2026-06-30",
  "updated":"2026-06-30"
}
```


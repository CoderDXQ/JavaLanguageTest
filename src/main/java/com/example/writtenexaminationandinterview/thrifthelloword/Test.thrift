namespace java gen

enum RequestType{
    SAY_HELLO,
    QUERY_TIME,
}

struct Request{
1: required RequestType type;//请求类型 必选
2: required string name;//发起请求的人的名字  必选
3: optional i32 age;//发起请求人的年龄 可选
}

exception RequestException{
1: required i32 code;
2: optional string reason;
}

service HelloWordService{
string doAction(1: Request request) throws (1:RequestException qe);
}

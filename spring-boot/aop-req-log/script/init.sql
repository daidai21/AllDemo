CREATE TABLE req_backup IF NOT EXISTS (
    id BIGINT NOT NULL COMMENT "id",
    gmt_create TIMESTAMP COMMENT "请求时间",
    url VARCHAR(1024) COMMENT "",
    desc VARCHAR(1024) COMMENT "",
    http_method INT COMMENT "",
    class_method VARCHAR(1024) COMMENT "",
    remote_host VARCHAR(50) COMMENT "请求ip",
    remote_port VARCHAR(50) COMMENT "请求port",
    args VARCHAR(1024) COMMENT "",
);

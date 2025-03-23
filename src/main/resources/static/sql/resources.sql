CREATE TABLE resources (
    resource_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    image_url VARCHAR(255),
    category VARCHAR(50),  -- 例: '小学校', '中学校', '高校'
    user_id INT REFERENCES users(user_id) ON DELETE CASCADE,  -- アップロード者
    likes INT DEFAULT 0,  -- いいねの数
    create_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

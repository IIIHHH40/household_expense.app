##　実際に行ったこと

## AWSでRDSダッシュボードを開いてデータベースを作成した
エンジン:SQL
VPCをLambdaと合わせた
Secrets Managerにパスワードを保存した
RDSのSGにルールを追加した
## Secrets Managerの利点
コードにパスワードを直接書かなくてもよくなる
LambdaがJava内で"GetSecretValue"を呼ぶと取得できる
## DBeaverからDBを作成した
DBeaverに以下の情報を入力してRDSと接続
```
・Host
・Port
・Database
・Username
・Password
```
実際にDBを作成
'''CREATE TABLE records (

    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    amount INT,
    category VARCHAR(50),
    memo VARCHAR(200),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
'''
をDBeaverで入力した
## LambdaからRDSに接続できるようにした
pom.xmlにdependencyを追加
lambdaのIAMに権限を付けた

## エラーがでるとき
context.getLogger().log("");でログを出力してCloudWatchを見ることでどこがエラーの原因となっているのか調べた



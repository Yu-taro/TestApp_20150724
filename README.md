###概要
---
これはアライドアーキテクツエンジニアブログ  
url： 
に掲載したAndroidアプリのソースコードです。 

####app/src/main/java/com/example/testapp/Testapp.java

```
    private final String APPLICATION_ID = "$PARSE_APP_ID";
    private final String SECRET_KEY = "$PARSE_CLIENT_KEY\"";
```

にお使いのParse.comアプリケーションのキーを入れてご使用ください。  

####ParseCloudCode用のmain.js

```
Parse.Cloud.afterSave("Message", function(request){
	Parse.Cloud.useMasterKey(); //特権ユーザーにチェンジ
	
    //保存されたオブジェクトを取り出す
    var saved = request.object;
    var username = saved.get("username");
    var body = saved.get("body");
    
    //Push通知で送信するメッセージ
    var message = "[" + username + "さん]" + body;
    
    //Push通知を送る
    var pushQuery = new Parse.Query(Parse.Installation);
	Parse.Push.send({
		where: pushQuery,
		data: {
			alert: message,
			sendMessage: {
				username: username,
				body: body
			}
		}
	},
	{
		success: function(){
			console.log("PushSuccess"); //ダッシュボードのLogsに出ます
		},
		error:function(){
			console.log("PushError");
		}
	}
	);
});
```


ご指摘やご質問等ありましたら[@yutailang0119](https://twitter.com/yutailang0119)までお願い致します:)  

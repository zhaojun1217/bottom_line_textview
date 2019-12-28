# Android带下划线的textview

---

一个简单的单行textview

---
要实现带下划线的textview其实有很多方法,可以参考另一位同学的总结 

[简书传送门](https://www.jianshu.com/p/792f67f3d689)

我这个的做法是封了一个布局代码块

--- 
## 使用配置

1.在project的build.gradle中加入jitpack

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
2.在app的build.gradle中导入依赖

**ps : Tag对应版本号,版本号如1.0.3是支持androidx的版本,1.0.1_sl的是关闭androidx的版本,请选用适合的版本**

```
dependencies {
	     // implementation 'com.github.zhaojun1217:bottom_line_textview:1.0.3'
	        implementation 'com.github.zhaojun1217:bottom_line_textview:1.0.1_sl'
	}
```

--- 
## 使用方法

```
可以在xml中直接使用
        父布局添加 tools:context=".xxxx" (commond+回车/ctrl+回车即可加上)
        app:bottomLineDefaultText="测试的文本" 设置文本
        app:bottomLineLineColor="#005590"    下划线颜色
        app:bottomLineLineSize="1"           下划线高度
        app:bottomLineShowLine="true"        是否显示下划线
        app:bottomLineTextBold="true"        是否设置粗体文字
        app:bottomLineTextColor="#005590"    下划线颜色
        app:bottomLineTextSize="20"          文字字号
        
```

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.zhaoj.bottom_line_textview.BottomLineTextView
        android:id="@+id/bltTest"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        app:bottomLineDefaultText="测试的文本"
        app:bottomLineLineColor="#005590"
        app:bottomLineLineSize="1"
        app:bottomLineShowLine="true"
        app:bottomLineTextBold="true"
        app:bottomLineTextColor="#005590"
        app:bottomLineTextSize="20" />


</RelativeLayout>
```

也可以在代码中设置,单独设置,链式,都可以


```
 private BottomLineTextView bltTest;

 bltTest = findViewById(R.id.bltTest);

//        bltTest.setText("测试的文本ss");
//        bltTest.setLineColor(0xff00ff00);
//        bltTest.setShowLine(true);
//        bltTest.setTextSize(20);
//        bltTest.setLineSize(4);
//        bltTest.setTextBold(true);
//        bltTest.setTextColor(0xff00ff00);

        bltTest.setText("测试的文本_测试的文本_测试的文本")  // 设置文本        string
                .setTextColor(0xff770000)                // 设置文本颜色    int
                .setLineColor(0xff000044)                // 设置下划线颜色  int
                .setTextBold(true)                       // 是否加粗文本    bool
                .setShowLine(true)                       // 是否隐藏下划线  bool
                .setTextSize(20)                         // 设置文本字号    int
                .setLineSize(0.5f)                       // 设置下划线宽度  float
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,
                             "文本 ： "+bltTest.getText() + "\n" +
                                        "下划线颜色 ： "+ bltTest.getLineColor() + "\n" +
                                        "下划线size ： "+ bltTest.getLineSize() + "\n" +
                                        "字体颜色 ： "+ bltTest.getTextColor() + "\n" +
                                        "字体大小 ： "+ bltTest.getTextSize(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
```

---

# 有图有真相

![image](https://github.com/zhaojun1217/bottom_line_textview/blob/master/images/bottom.png)


---

**此项目本来是为了学习jitpack发布,后来想想怎么也算是个“小轮子”,就发布出来玩玩,喜欢的同学给个小星星~**

**CSDN** [传送门](https://blog.csdn.net/woyvzhuixun/article/details/103745719)

# bottomSlideLayout

最近在开发过程中总是遇到从底部划出菜单的需求，自己研究了下作了一个可以适应各种底部划出需求的控件，使用起来很简单，只要把需要划出的内容set到这个控件中就可以了。

先上效果图。
![这里写图片描述](http://img.blog.csdn.net/20151022110427311)

PS:
   初始化
```
        BottomSlideLayout bottomSlideLayout= (BottomSlideLayout) findViewById(R.id.slide_layout);//初始化这个控件
        View view= View.inflate(this,R.layout.silde_layout,null);//初始化底部需要滑出的layout
        bottomSlideLayout.setSlideLayout(view);//将layout加入到控件中
        bottomSlideLayout.setAutoSlideDown(true);//设置为点击阴影处时滑出部分自动消失
```
   事件设置
```
        bottomSlideLayout.slideUp();//滑出layout
        
        bottomSlideLayout.slideDown();//收回layout
```


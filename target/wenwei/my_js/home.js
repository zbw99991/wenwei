//瀑布流初始化代码
$(".grid").masonry({
    itemSelector: ".grid-item", //告诉框架 选择器是什么
    /*columnWidth: 300, //告诉框架 每个元素所占宽度(元素宽度+间距)*/
})
//图片加载完之后让瀑布流处理一下显示布局
$(".grid").imagesLoaded().progress(function () {
    $(".grid").masonry("layout");//让瀑布流重新计算显示效果  解决图片层叠问题
});
/*漂浮广告*/
$(window).scroll(function () {
    let docHeight = $(document).scrollTop();
    $("#imgfloat").animate({"top": docHeight+250}, 30);
});
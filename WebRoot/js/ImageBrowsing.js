/**
 * 创建者：梁树松
 * @param imgUpload  file id
 * @param destination div id
 * @param width  图片高度
 * @param height 图片宽度
 * 
 */
function browse(imgUpload,destination,width,height){
 //判断浏览器是否有FileReader接口
    if(typeof FileReader =='undefined')
    {
       //$("#"+destination).css({'background':'none'}).html('');
        //如果浏览器是ie
        if($.browser.msie===true)
        {	
        	//alert($.browser.msie);
            //ie6直接用file input的value值本地预览
            if($.browser.version==6)
            {
                $("#"+imgUpload).change(function(event){ 
                      //ie6下怎么做图片格式判断?
                      var src = event.target.value;
                      //var src = document.selection.createRange().text;        //选中后 selection对象就产生了 这个对象只适合ie
                      var img = '<img class="preview" src="'+src+'" width="'+width+'px" height="'+height+'px" />';
                      $("#"+destination).empty().append(img);
                      
                  });
            }
            //ie7,8使用滤镜本地预览
            else if($.browser.version==7 || $.browser.version==8)
            {
                $("#"+imgUpload).change(function(event){
                	setImg(this,destination,width,height);
                 });
            }else if($.browser.version==9){
            	$("#"+imgUpload).change(function(event){
            		
            		$(event.target).select();
            		
            		//非iframe 调用
            		//$(event.target).blur();
            		
            		//iframe 用调
            		window.parent.document.body.focus(); 
            		
                    var src = document.selection.createRange().text;
                    
                   // alert("ssd==="+$("#"+imgUpload).val());
                   // alert("src55=="+src);
                    var img = '<img class="preview" id="preview_'+destination+'"  src="'+src+'" width="'+parseInt(width)+'px" height="'+parseInt(height)+'px" />';
                    $("#"+destination).empty().append(img);
                    $("#"+destination).attr('style','filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)');
                    var domDXI = document.getElementById(""+destination+"");
                    var objPreview = document.getElementById('preview_'+destination+'' );
                    //使用滤镜 成功率高
                    domDXI.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src= src;
                    domDXI.innerHTML = '';
                    //使用和ie6相同的方式 设置src为绝对路径的方式 有些图片无法显示 效果没有使用滤镜好
                    autoSizePr(domDXI,parseInt(width),parseInt(height));
                    objPreview.style.display ='none';
               });
            	function autoSizePr(objPre, w,h){
                    objPre.style.width = w +'px';
                    objPre.style.height = h +'px';
                }
            } else{
            	$("#"+imgUpload).change(function(event){
                    $(event.target).select();
                    this.blur();
                    var src = document.selection.createRange().text;
                    var dom = document.getElementById(''+destination+'');
                    //使用滤镜 成功率高
                    dom.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src= src;
                    dom.innerHTML = '';
                    //使用和ie6相同的方式 设置src为绝对路径的方式 有些图片无法显示 效果没有使用滤镜好
                    var img = '<img class="preview" src="'+src+'" width="'+width+'px" height="'+height+'px" />';
                    $("#"+destination).empty().append(img);
                    
               });
            }
        }
        //如果是不支持FileReader接口的低版本firefox 可以用getAsDataURL接口
        else if($.browser.mozilla===true)
        {
            $("#"+imgUpload).change(function(event){
                //firefox2.0没有event.target.files这个属性 就像ie6那样使用value值 但是firefox2.0不支持绝对路径嵌入图片 放弃firefox2.0
                //firefox3.0开始具备event.target.files这个属性 并且开始支持getAsDataURL()这个接口 一直到firefox7.0结束 不过以后都可以用HTML5的FileReader接口了
                if(event.target.files)
                {
                  //console.log(event.target.files);
                  for(var i=0;i<event.target.files.length;i++)
                  {    
                        var img = '<img class="preview" src="'+event.target.files.item(i).getAsDataURL()+'" width="'+width+'px" height="'+height+'px"/>';
                      $("#"+destination).empty().append(img);
                      
                  }
                }
                else
                {
                    //console.log(event.target.value);
                    //$("#imgPreview").attr({'src':event.target.value});
                }
                });
        }
    }
    else
    {
    	
    	// version 1
        /*$("#"+imgUpload).change(function(e){
          var file = e.target.files[0];
          var fReader = new FileReader();
          //console.log(fReader);
          //console.log(file);
          fReader.onload=(function(var_file)
          {
              return function(e)
              {
                  $("#imgPreview").attr({'src':e.target.result,'alt':var_file.name});
              }
          })(file);
          fReader.readAsDataURL(file);
          });*/
          
          //单图上传 version 2 
          /*$("#"+imgUpload).change(function(e){
                var file = e.target.files[0];
                var reader = new FileReader();  
                reader.onload = function(e){
                    //displayImage($('bd'),e.target.result);
                    //alert('load');
                    $("#imgPreview").attr({'src':e.target.result});
                }
                reader.readAsDataURL(file);
              });*/
          //多图上传 input file控件里指定multiple属性 e.target是dom类型
           $("#"+imgUpload).change(function(e){ 
                   for(var i=0;i<e.target.files.length;i++)
                       {
                           var file = e.target.files.item(i);
                        //允许文件MIME类型 也可以在input标签中指定accept属性
                        //console.log(/^image\/.*$/i.test(file.type));
                        if(!(/^image\/.*$/i.test(file.type)))
                        {
                            continue;            //不是图片 就跳出这一次循环
                        }
                        
                        //实例化FileReader API
                        var freader = new FileReader();
                        freader.readAsDataURL(file);
                        freader.onload=function(e)
                        {
                            var img = '<img class="preview" src="'+e.target.result+'" width="'+width+'px" height="'+height+'px"/>';
                            $("#"+destination).empty().append(img);
                            
                        }
                       }
                   
               });
               
          //处理图片拖拽的代码
          var destDom = document.getElementById(''+destination+'');
          destDom.addEventListener('dragover',function(event){
              event.stopPropagation();
              event.preventDefault();
              },false);
              
          destDom.addEventListener('drop',function(event){
              event.stopPropagation();
              event.preventDefault();
              var img_file = event.dataTransfer.files.item(0);                //获取拖拽过来的文件信息 暂时取一个
              //console.log(event.dataTransfer.files.item(0).type);
              if(!(/^image\/.*$/.test(img_file.type)))
              {
                  alert('您还未拖拽任何图片过来,或者您拖拽的不是图片文件');
                  return false;
              }
              fReader = new FileReader();
              fReader.readAsDataURL(img_file);
              fReader.onload = function(event){
                  destDom.innerHTML='';
                  destDom.innerHTML = '<img class="preview" src="'+event.target.result+'" width="'+width+'px" height="'+height+'px"/>';    
                  };
          },false);
    }
}


function setImg(obj,destination,width,height){
    if( !obj.value.match( /.jpg|.gif|.png|.bmp/i ) ){
        alert('图片格式无效！');
        return false;
    }
   
    var img = '<img class="preview" id="preview_'+destination+'" src="" width="'+width+'px" height="'+height+'px" />';
    $("#"+destination).empty().append(img);
    $("#"+destination).attr('style','filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)');
    if($.browser.msie){
       if($.browser.version == 6.0){
          $("#preview_"+destination+"").attr("src",obj.value);
          
       }else{
          var objPreview = document.getElementById('preview_'+destination+'' );
          var objPreviewFake = document.getElementById(''+destination+'' );
          obj.select();
          var imgSrc =document.selection.createRange().text;
          objPreviewFake.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src= imgSrc;
          //alert("width=="+width+";height=="+height);
          autoSizePreview(objPreviewFake,parseInt(width),parseInt(height));
          objPreview.style.display ='none';
       }
    }
    
    function autoSizePreview(objPre, w,h){
        objPre.style.width = w +'px';
        objPre.style.height = h +'px';
    }
    
}

//浏览图片
function browsePicture(){
	var img=new Array;
	imagePreview(img);
}




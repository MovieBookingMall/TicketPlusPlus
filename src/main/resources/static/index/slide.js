~function(i,t){function n(t){this.config=i.extend({},s,t),this.init()}var s={speed:"400",duration:"2000",itemsPerSlide:1,autoplay:!1,wrap:".ui-slide-wrap",content:".ui-slide-content",index:".ui-slide-index",max:".ui-slide-max",btnPrev:".btn-prev",btnNext:".btn-next",controlNav:".ui-control-nav",marginRight:0,lazyload:!1,direction:"h"};n.prototype={init:function(){var t=this;this.index=1,this.isPlaying=!1,this.duration=this.config.duration,this.wrap=i(this.config.wrap),this.items=this.wrap.find(".ui-slide-item"),this.itemsPerSlide=this.config.itemsPerSlide,this.itemCount=this.items.length/this.itemsPerSlide,1!==this.itemCount&&(this.wrapWidth="",this.marginRight=this.config.marginRight,this.content=this.wrap.find(this.config.content),this.setpMax=this.content.data("index-max"),this.autoplay=this.config.autoplay,this.lazyload=this.config.lazyload,this.nav=this.wrap.parents().find(this.config.controlNav),this.first=this.items.slice(0,this.config.itemsPerSlide).clone(),this.last=this.items.slice(-this.config.itemsPerSlide).clone(),this.lazyload&&(this.first.find(".poster img").each(function(){var t=i(this);t.attr("src",t.data("original"))}),this.last.find(".poster img").each(function(){var t=i(this);t.attr("src",t.data("original"))})),this.content.append(this.first).prepend(this.last),this.wrapWidth=this.content.outerWidth(!0)/(this.itemCount+2),this.content.css({left:-(this.wrapWidth+this.marginRight)}),this.btnPrev=this.wrap.parents().find(this.config.btnPrev),this.btnNext=this.wrap.parents().find(this.config.btnNext),this.listen(),this.nav.find("a").click(i.proxy(this.turnto,this)),this.autoplay&&(this.play(),this.wrap.hover(function(){t.pause()},function(){t.play()}),i(this.btnPrev).hover(function(){t.pause()},function(){t.play()}),i(this.btnNext).hover(function(){t.pause()},function(){t.play()})),this.lazyload&&this.lazyloadimg())},lazyloadimg:function(){var t=this.index*this.itemsPerSlide,n=(this.index+1)*this.itemsPerSlide+1;this.wrap.find(".poster img").each(function(s,e){s>=t&&s<n&&i(this).attr("src",i(this).data("original"))})},play:function(){this.interval=setInterval(i.proxy(this.next,this),this.duration)},listen:function(){this.btnPrev.click(i.proxy(this.prev,this)),this.btnNext.click(i.proxy(this.next,this))},pause:function(){clearTimeout(this.interval),this.interval=null},prev:function(){if(!this.isPlaying){this.isPlaying=!0;var i=this;this.index--,this.content.animate({left:-i.index*(i.wrapWidth+i.marginRight)},i.config.speed,function(){i.lazyload&&i.lazyloadimg(),i.index<=0&&(i.index=i.itemCount,i.lazyload&&i.lazyloadimg(),i.content.css({left:-i.index*(i.wrapWidth+i.marginRight)})),i.isPlaying=!1}),this.indexTip()}},next:function(){if(!this.isPlaying){this.isPlaying=!0;var i=this;this.index++,this.content.animate({left:-i.index*(i.wrapWidth+i.marginRight)},i.config.speed,function(){i.lazyload&&i.lazyloadimg(),i.index>=i.itemCount+1&&(i.content.css({left:-(i.wrapWidth+i.marginRight)}),i.index=1),i.isPlaying=!1}),this.indexTip()}},indexTip:function(){var i;switch(this.index){case 0:i=this.itemCount;break;case this.itemCount+1:i=1;break;default:i=this.index}this.wrap.parents().find(this.config.index).text(i),this.nav.find(".active").removeClass("active").end().find("a").eq(i-1).addClass("active")},turnto:function(t){if(!this.isPlaying){this.pause();var n=this;n.index=i(t.target).data("index"),this.content.animate({left:-n.index*(n.wrapWidth+n.marginRight)},n.config.speed,function(){n.isPlaying=!1}),this.indexTip()}}},t.Slide=n}(jQuery,window);
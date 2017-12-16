function openColorBox(){
        $.colorbox({
          iframe:true,
          width:"80%",
          height:"80%",
          href: "http://www.sitepoint.com",
          onLoad: function() {
            $('#cboxClose').remove();
            setTimeout(function(){
              $(window).colorbox.close();
            }, 5000)
          }
        });
      }

      function countDown(){
        seconds--
        $("#seconds").text(seconds);
        if (seconds === 0){
          openColorBox();
          clearInterval(i);
        }
      }

      var seconds = 5,
          i = setInterval(countDown, 1000);
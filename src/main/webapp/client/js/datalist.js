  

    // -----------------------------------2-------------------------------------------


     var count2 = 1;
    var group2 = document.getElementById('listtwo');
    var list_group2 = group2.querySelector('li ul');
    var list_array2 = group2.querySelectorAll('li ul li');
    var search2 = group2.getElementsByTagName('input')[0];
    
    search2.addEventListener('input', function (e) {
      for (var i = 0; i < list_array2.length; i++) { matching2(list_array2[i]) }
      show_list2(list_group2);
      key_up_down2();
    });
    
    search2.addEventListener('click', function (e) {
      init_list2();
      show_list2(list_group2);
      key_up_down2();
    });
    
    search2.addEventListener('keypress', function (e) {
      if (e.keyCode == 13) { e.target.value = list_group2.querySelector('[data-highlight="true"]').innerHTML }
      hide_list2(list_group2)
      init_list2();
    });
    
    function matching2(item) {
      var str = new RegExp(search2.value, 'gi');
      if (item.innerHTML.match(str)) { item.dataset.display = 'true'} 
      else { item.dataset.display = 'false'; item.dataset.highlight = 'false'; count2 = 0 }
    }
    
    function init_list2() {
      count2 = 0;
      for (var i = 0; i < list_array2.length; i++) { init_item2(list_array2[i]); list_array2[i].addEventListener('click', copy_paste2); }
    }
    
    function init_item2(item) { item.dataset.display = 'true'; item.dataset.highlight = 'false'; }
    
    function copy_paste2() { search2.value = this.innerHTML;
      // todo : check match of list text and input value for .current 
      init_list2(); hide_list2(list_group2);
    }
    
    function hide_list2(ele) { ele.dataset.toggle = 'false' }
    
    function show_list2(ele) { ele.dataset.toggle = 'true' }
    
    function key_up_down2() {
      var items = group2.querySelectorAll('li[data-display="true"]');
      var last = items[items.length - 1];
      var first = items[0];
    
      search2.onkeydown = function (e) {
        
        if (e.keyCode === 38) {
          count2--;
          count2 = count2 <= 0 ? items.length : count2;
          items[count2 - 1].dataset.highlight = items[count2 - 1] ? 'true' : 'false';
          if (items[count2]) { items[count2].dataset.highlight = 'false'; }
          else { first.dataset.highlight = 'false'; }
        } 
        
        if (e.keyCode === 40) {
          items[count2].dataset.highlight = items[count2] ? 'true' : 'false';
          if (items[count2 - 1]) { items[count2 - 1].dataset.highlight = 'false'; }
          else { last.dataset.highlight = 'false'; }
          count2++;
          count2 = count2 >= items.length ? 0 : count2;
        }
      };
    }
    
    group2.addEventListener('mouseleave', function(event){
      if (event.target != list_group2 && event.target.parentNode != list_group2){ list_group2.dataset.toggle = 'false' }
    });
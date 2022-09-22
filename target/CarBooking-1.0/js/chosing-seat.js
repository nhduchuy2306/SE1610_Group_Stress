var firstSeatLabel = 1;
$(document).ready(function () {
  var $cart = $("#selected-seats"),
    $counter = $("#counter-seat"),
    $total = $("#total-seat"),
    choice = [],
    sc = $("#seat-map-seat").seatCharts({
      map: ["ee", "ee", "ee", "ee", "ee", "ee", "ee", "ee"],
      seats: {
        f: {
          price: 100,
          classes: "first-class", //your custom CSS class
          category: "First Class",
        },
        e: {
          price: 40,
          classes: "economy-class", //your custom CSS class
          category: "Economy Class",
        },
      },
      naming: {
        top: false,
        getLabel: function (character, row, column) {
          return firstSeatLabel++;
        },
      },
      legend: {
        node: $("#legend"),
        items: [
          ["e", "available", "Economy Class"],
          ["f", "unavailable", "Already Booked"],
        ],
      },
      click: function () {
        if (this.status() == "available") {
          choice.push(this.settings.id);
          console.log(choice);
          //console.log(sc.find('selected').seatIds)
          //let's create a new <li> which we'll add to the cart items
          //this.data().category +
          $(
            "<li>" +
              " Seat # " +
              this.settings.label +
              ": <b>$" +
              this.data().price +
              '</b> <a class="cancel-cart-item"></a></li>'
          )
            .attr("id", "cart-item-" + this.settings.id)
            .data("seatId", this.settings.id)
            .appendTo($cart);
          /*
           * Lets update the counter and total
           *
           * .find function will not find the current seat, because it will change its stauts only after return
           * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
           */
          $counter.text(sc.find("selected").length + 1);
          $total.text(recalculateTotal(sc) + this.data().price);
          return "selected";
        } else if (this.status() == "selected") {
          const index = choice.indexOf(this.settings.id);
          if (index > -1) {
            // only splice array when item is found
            choice.splice(index, 1); // 2nd parameter means remove one item only
          }
          console.log(choice);
          //update the counter
          $counter.text(sc.find("selected").length - 1);
          //and total
          $total.text(recalculateTotal(sc) - this.data().price);
          //remove the item from our cart
          $("#cart-item-" + this.settings.id).remove();
          //seat has been vacated
          return "available";
        } else if (this.status() == "unavailable") {
          //seat has been already booked
          return "unavailable";
        } else {
          return this.style();
        }
      },
    });

  //this will handle "[cancel]" link clicks
  $("#selected-seats").on("click", ".cancel-cart-item", function () {
    //let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
    sc.get($(this).parents("li:first").data("seatId")).click();
  });
  seatAreChosen = ["1_2", "4_1", "7_1", "7_2"];
  //let's pretend some seats have already been booked
  sc.get(seatAreChosen).status("unavailable");
});

function recalculateTotal(sc) {
  var total = 0;
  //basically find every selected seat and sum its price
  sc.find("selected").each(function () {
    total += this.data().price;
  });
  return total;
}

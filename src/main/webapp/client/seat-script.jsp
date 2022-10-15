<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    var btn_choose_seat = $('.btn-choose-seat');
    var totalSeat = $("input[name=totalSeat]");
    var button_confirm = $(".choose-seat");

    console.log(button_confirm.eq(0));
    console.log(btn_choose_seat.eq(0).data("target"));
    console.log(btn_choose_seat.eq(0).data("index"));
    console.log(parseInt(totalSeat.eq(0).val()));

    var firstSeatLabel = 1;
    var price = $("input[name=price]").val();
    
    var choice = [];


    $(document).ready(function () {
        btn_choose_seat.click(function () {
            var tripID = $(this).data('index');

            console.log(tripID);

            var unavailabeSeat = [];
            var index = btn_choose_seat.index((this));
            var totalSeatForSeatMap = parseInt(totalSeat.eq(index).val());
//            var buttonConfirm = button_confirm.eq(index);

            $.ajax({
                url: "/ETrans/seat",
                type: 'GET',
                data: {
                    tripID: tripID,
                    action: 'showUnavailable'
                },
                success: function (data) {
                    var string = data;
                    var array = string.split(",");
                    array.pop();
                    for (let item in array) {
                        unavailabeSeat.push(array[item]);
                    }
                    getData(unavailabeSeat);
                }
            });

            drawMapSeat(index, [], totalSeatForSeatMap,tripID,choice);
            function getData(sm) {
                drawMapSeat(index, sm, totalSeatForSeatMap,tripID,choice);
            }
        });
    });

    function generateSeatMap(totalSeat) {
        if (totalSeat === 16) {
            return [
                "e__ee",
                "ee_ee",
                "ee_ee",
                "eeeee"
            ];
        }
        if (totalSeat === 29) {
            return [
                "e____",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "eeeee"
            ];
        }
        if (totalSeat === 45) {
            return [
                "e____",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "ee_ee",
                "eeeee"
            ];
        }
    }

    function drawMapSeat(id, seatAreChosen, totalSeat,tripID, seatchoice) {
        seatAreChosen.push('A_1');
        var seatMap = generateSeatMap(totalSeat);
        var cart = $(".selected-seats").eq(id),
                counter = $(".counter-seat").eq(id),
                total = $(".total-seat").eq(id),
                sc = $(".seat-map-seat").eq(id).seatCharts({
            map: seatMap,
            seats: {
                e: {
                    price: parseInt(price.trim()),
                    classes: "economy-class", //your custom CSS class
                    category: "Economy Class"
                }
            },

            naming: {
                top: false,
                rows: ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'],
                columns: ['1', '2', '3', '4', '5']
            },
            legend: {
                node: $("#legend"),
                items: [
                    ["e", "available", "Economy Class"],
                    ["f", "unavailable", "Already Booked"],
                ]
            },
            click: function () {
                if (this.status() === "available") {
                    choice.push(this.settings.id);
                    console.log("inside chart: "+choice);
                    //console.log(sc.find('selected').seatIds)
                    //let's create a new <li> which we'll add to the cart items
                    //this.data().category +
                    $(
                            "<li>" +
                            this.settings.id +
                            ": <b>" +
                            this.data().price +
                            '</b> <a class="cancel-cart-item"></a></li>'
                            )
                            .attr("id", "cart-item-" + this.settings.id)
                            .data("seatId", this.settings.id)
                            .appendTo(cart);
                    counter.text(sc.find("selected").length + 1);
                    total.text(recalculateTotal(sc) + this.data().price);
                    return "selected";
                } else if (this.status() === "selected") {
                    const index = choice.indexOf(this.settings.id);
                    if (index > -1) {
                        // only splice array when item is found
                        choice.splice(index, 1); // 2nd parameter means remove one item only
                    }
                    console.log(choice);
                    //update the counter
                    counter.text(sc.find("selected").length - 1);
                    //and total
                    total.text(recalculateTotal(sc) - this.data().price);
                    //remove the item from our cart
                    $("#cart-item-" + this.settings.id).remove();
                    //seat has been vacated
                    return "available";
                } else if (this.status() === "unavailable") {
                    //seat has been already booked
                    return "unavailable";
                } else {
                    return this.style();
                }
            }
        });
        console.log("after chart: "+choice)
        //this will handle "[cancel]" link clicks
        $("#selected-seats").on("click", ".cancel-cart-item", function () {
            //let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
            sc.get($(this).parents("li:first").data("seatId")).click();
        });
//        seatAreChosen = ['A_1', 'B_1', 'C_4', 'D_5'];
        //let's pretend some seats have already been booked
        sc.get(seatAreChosen).status("unavailable");
        
        console.log(choice);

        button_confirm.eq(id).click(function () {
            console.log("click");
            url = window.location.href;
            position = url.search("ETrans") + 7;
            newurl = url.slice(0, position);
            window.location.replace(newurl + 'book?' + "tripID=" + tripID + "&" + "seatID=" + choice + "&action=createTrip");
        });
    }

    function recalculateTotal(sc) {
        var total = 0;
        //basically find every selected seat and sum its price
        sc.find("selected").each(function () {
            total += this.data().price;
        });
        return total;
    }
</script>
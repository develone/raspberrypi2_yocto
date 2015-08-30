// File ../examples/for.vhd translated with vhd2vl v2.0 VHDL to Verilog RTL translator
// Copyright (C) 2001 Vincenzo Liguori - Ocean Logic Pty Ltd - http://www.ocean-logic.com
// Modifications (C) 2006 Mark Gonzales - PMC Sierra Inc
// 
// vhd2vl comes with ABSOLUTELY NO WARRANTY
// ALWAYS RUN A FORMAL VERIFICATION TOOL TO COMPARE VHDL INPUT TO VERILOG OUTPUT 
// 
// This is free software, and you are welcome to redistribute it under certain conditions.
// See the license file license.txt included with the source for details.


module forp(
reset,
sysclk
);

input reset, sysclk;

wire   reset;
wire   sysclk;


reg  selection;
reg [6:0] egg_timer;

  always @(posedge reset or posedge sysclk) begin : P1
    reg  timer_var = 0;
    reg  a,i,j,k;
    reg [31:0] zz5;
    reg [511:0] zz;

    if(reset == 1'b 1) begin
      selection <= 1'b 1;
      timer_var = 2;
      egg_timer <= {7{1'b0}};
    end else begin
      //  pulse only lasts for once cycle
      selection <= 1'b 0;
      egg_timer <= {7{1'b1}};
      for (i=0; i <= j * k; i = i + 1) begin 
        a = a + i;
        for (k=a - 9; k >=  -14; k = k - 1) begin
          zz5 = zz[31 + k:k] ;
        end
        // k
      end
      // i
    end
  end


endmodule

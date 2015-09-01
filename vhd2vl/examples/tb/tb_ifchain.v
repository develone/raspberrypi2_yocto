
`timescale 1ns/10ps

module tb_ifchain1;

reg clk;

wire   status;

reg [3:0] a;
reg [3:0] b;

initial begin
    $dumpfile("vcd/ifchain1.vcd");
    $dumpvars(0, tb_ifchain1);
end

initial begin
    $from_myhdl(
        a,
        b,
        clk
    );
    $to_myhdl(
        status
    );
end
wire rstn;

initial begin
	# 10 a = 10;
	# 20 b = 8;
	# 200 $stop;

end

test dut_test(clk, rstn);   

endmodule

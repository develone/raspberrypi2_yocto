-- File: ram.vhd
-- Generated by MyHDL 1.0dev
-- Date: Mon Jul 27 20:24:53 2015


library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;
use std.textio.all;

use work.pck_myhdl_10.all;

entity ram is
    port (
        dout: out unsigned(7 downto 0);
        din: in unsigned(7 downto 0);
        addr: in unsigned(6 downto 0);
        we: in std_logic;
        clk: in std_logic
    );
end entity ram;
-- Ram model 

architecture MyHDL of ram is





type t_array_mem is array(0 to 128-1) of unsigned(7 downto 0);
signal mem: t_array_mem;

begin





RAM_WRITE: process (clk) is
begin
    if rising_edge(clk) then
        if bool(we) then
            mem(to_integer(addr)) <= din;
        end if;
    end if;
end process RAM_WRITE;



dout <= mem(to_integer(addr));

end architecture MyHDL;

defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator

  describe "percentage_grade" do
    test "Fail" do
      assert 0 == Calculator.percentage_grade(%{homework: [], labs: [], midterm: 0, final: 0 })
    end

    test "Pass" do
      assert 50 == Calculator.percentage_grade(%{homework: [0.5], labs: [0.5], midterm: 0.5, final: 0.5 })
    end
  end

  describe "letter_grade" do
    # Cycle all standard grades
    test "A+ to E" do
      for {grade, score} <- Map.to_list(%{"A+" => 1, "A" => 0.85, "A-" => 0.8, "B+" => 0.75, "B" => 0.7, "C+" => 0.65, "C" => 0.6, "D" => 0.5, "E" => 0.45 }) do
          assert Calculator.letter_grade(%{homework: [score], labs: [score, score, score], midterm: score, final: score}) == grade
      end
    end

    test "F" do
      # Labs at least .25 Homework and Final at least .4
      assert "F" == Calculator.letter_grade(%{homework: [0.4], labs: [0.25,0.25,0.25], midterm: 0.4, final: 0.4 })
    end

    test "EIN" do
      assert "EIN" == Calculator.letter_grade(%{homework: [], labs: [], midterm: 0, final: 0 })
    end
  end


  describe "numeric_grade" do
    test "10 to 1" do
      for {grade, score} <- Map.to_list(%{10 => 1, 9 => 0.85, 8 => 0.8, 7 => 0.75, 6 => 0.7, 5 => 0.65, 4 => 0.6, 3 => 0.55, 2 => 0.5, 1 => 0.45 }) do
          assert Calculator.numeric_grade(%{homework: [score], labs: [score, score, score], midterm: score, final: score}) == grade
      end
    end

    test "00" do
      #Labs at least .25 Homework and Final at least .4
      assert 0 == Calculator.numeric_grade(%{homework: [0.4], labs: [0.25,0.25,0.25], midterm: 0.45, final: 0.45 })
    end

    test "EIN" do
      assert 0 == Calculator.numeric_grade(%{homework: [], labs: [], midterm: 0, final: 0 })
    end
  end
end

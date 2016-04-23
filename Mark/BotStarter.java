// // Copyright 2015 theaigames.com (developers@theaigames.com)

//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at

//        http://www.apache.org/licenses/LICENSE-2.0

//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//	
//    For the full copyright and license information, please view the LICENSE
//    file that was distributed with this source code.

package bot;
import java.util.Random;

/**
 * BotStarter class
 * 
 * Magic happens here. You should edit this file, or more specifically
 * the makeTurn() method to make your bot do more than random moves.
 * 
 * @author Jim van Eeden <jim@starapple.nl>, Joost de Meij <joost@starapple.nl>
 */

public class BotStarter {	
    Field field;

    /**
    * Makes a turn.
    *
    * @return The column where the turn was made.
    */
    public int makeTurn() {
		int winAns = 9; //Answer to fill in when checking win;

		/* Place first turn in the middle always */
		if (BotParser.mRound == 1 || BotParser.mRound == 2)
			return 3;
		/* Check if there is a win condition after enough rounds */
		else if (BotParser.mRound > 5)
			winAns = BotParser.mField.checkWin(BotParser.mBotId);
			if (winAns != 9)
				return winAns;
			
			winAns = BotParser.mField.checkWin(BotParser.mBotIdE);
			if (winAns != 9)
				return winAns;
		/* Random Move */
		else {
			int move = new Random().nextInt(7);     
			return move;
		}
    }
     
 	public static void main(String[] args) {
 		BotParser parser = new BotParser(new BotStarter());
 		parser.run();
 	}
 	
 }

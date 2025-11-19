package first.client.playercharacter.CharacterClasses.Knight;

public enum Animations  {





    
IDLE,
WALKING_A,
WALKING_B,
WALKING_C,
WALKING_BACKWARDS,
RUNNING_A,
RUNNING_B,
RUNNING_STRAFE_RIGHT,
RUNNING_STRAFE_LEFT,
JUMP_FULL_SHORT,
JUMP_FULL_LONG,
JUMP_START,
JUMP_IDLE,
JUMP_LAND,
DODGE_FORWARD,
DODGE_BACKWARD,
DODGE_RIGHT,
DODGE_LEFT,
PICK_UP,
USE_ITEM,
THROW,
INTERACT,
CHEER,
HIT_A,
HIT_B,
DEATH_A,
DEATH_A_POSE,
DEATH_B,
DEATH_B_POSE,
MELEE_ATTACK_CHOP_1H,
MELEE_ATTACK_SLICE_DIAGONAL_1H,
MELEE_ATTACK_SLICE_HORIZONTAL_1H,
MELEE_ATTACK_STAB_1H,
MELEE_IDLE_2H,
MELEE_ATTACK_CHOP_2H,
MELEE_ATTACK_SLICE_2H,
MELEE_ATTACK_STAB_2H,
MELEE_ATTACK_SPIN_2H,
MELEE_ATTACK_SPINNING_2H,
DUALWIELD_MELEE_ATTACK_CHOP,
DUALWIELD_MELEE_ATTACK_SLICE,
DUALWIELD_MELEE_ATTACK_STAB,
UNARMED_IDLE,
UNARMED_POSE,
UNARMED_MELEE_ATTACK_PUNCH_A,
UNARMED_MELEE_ATTACK_PUNCH_B,
UNARMED_MELEE_ATTACK_KICK,
BLOCK,
BLOCKING,
BLOCK_HIT,
BLOCK_ATTACK,
RANGED_AIMING_1H,
RANGED_SHOOT_1H,
RANGED_SHOOTING_1H,
RANGED_RELOAD_1H,
RANGED_AIMING_2H,
RANGED_SHOOT_2H,
RANGED_SHOOTING_2H,
RANGED_RELOAD_2H,
SPELLCAST_SHOOT,
SPELLCAST_RAISE,
SPELLCAST_LONG,
SPELLCASTING,
LIE_DOWN,
LIE_IDLE,
LIE_POSE,
LIE_STAND_UP,
SIT_CHAIR_DOWN,
SIT_CHAIR_IDLE,
SIT_CHAIR_POSE,
SIT_CHAIR_STAND_UP,
SIT_FLOOR_DOWN,
SIT_FLOOR_IDLE,
SIT_FLOOR_POSE,
SIT_FLOOR_STAND_UP;

public static final String ANIMATIONS_PATH = "io.github.some_example_name.playercharacter.CharacterClasses.Knight.Animations";

public static String ASSOCIATED_CLASS_PATH = "io.github.some_example_name.playercharacter.CharacterClasses.Knight.Knight";

    public static String getAnimationsPath() {
        return ANIMATIONS_PATH;
    }

    public static String getAssociatedClassPath() {
        return ASSOCIATED_CLASS_PATH;
    }

public String getAnimation(){
    return switch (this) {
        case IDLE -> "Idle";
        case WALKING_A -> "Walking_A";
        case WALKING_B -> "Walking_B";
        case WALKING_C -> "Walking_C";
        case WALKING_BACKWARDS -> "Walking_Backwards";
        case RUNNING_A -> "Running_A";
        case RUNNING_B -> "Running_B";
        case RUNNING_STRAFE_RIGHT -> "Running_Strafe_Right";
        case RUNNING_STRAFE_LEFT -> "Running_Strafe_Left";
        case JUMP_FULL_SHORT -> "Jump_Full_Short";
        case JUMP_FULL_LONG -> "Jump_Full_Long";
        case JUMP_START -> "Jump_Start";
        case JUMP_IDLE -> "Jump_Idle";
        case JUMP_LAND -> "Jump_Land";
        case DODGE_FORWARD -> "Dodge_Forward";
        case DODGE_BACKWARD -> "Dodge_Backward";
        case DODGE_RIGHT -> "Dodge_Right";
        case DODGE_LEFT -> "Dodge_Left";
        case PICK_UP -> "PickUp";
        case USE_ITEM -> "Use_Item";
        case THROW -> "Throw";
        case INTERACT -> "Interact";
        case CHEER -> "Cheer";
        case HIT_A -> "Hit_A";
        case HIT_B -> "Hit_B";
        case DEATH_A -> "Death_A";
        case DEATH_A_POSE -> "Death_A_Pose";
        case DEATH_B -> "Death_B";
        case DEATH_B_POSE -> "Death_B_Pose";
        case MELEE_ATTACK_CHOP_1H -> "1H_Melee_Attack_Chop";
        case MELEE_ATTACK_SLICE_DIAGONAL_1H -> "1H_Melee_Attack_Slice_Diagonal";
        case MELEE_ATTACK_SLICE_HORIZONTAL_1H -> "1H_Melee_Attack_Slice_Horizontal";
        case MELEE_ATTACK_STAB_1H -> "1H_Melee_Attack_Stab";
        case MELEE_IDLE_2H -> "2H_Melee_Idle";
        case MELEE_ATTACK_CHOP_2H -> "2H_Melee_Attack_Chop";
        case MELEE_ATTACK_SLICE_2H -> "2H_Melee_Attack_Slice";
        case MELEE_ATTACK_STAB_2H -> "2H_Melee_Attack_Stab";
        case MELEE_ATTACK_SPIN_2H -> "2H_Melee_Attack_Spin";
        case MELEE_ATTACK_SPINNING_2H -> "2H_Melee_Attack_Spinning";
        case DUALWIELD_MELEE_ATTACK_CHOP -> "Dualwield_Melee_Attack_Chop";
        case DUALWIELD_MELEE_ATTACK_SLICE -> "Dualwield_Melee_Attack_Slice";
        case DUALWIELD_MELEE_ATTACK_STAB -> "Dualwield_Melee_Attack_Stab";
        case UNARMED_IDLE -> "Unarmed_Idle";
        case UNARMED_POSE -> "Unarmed_Pose";
        case UNARMED_MELEE_ATTACK_PUNCH_A -> "Unarmed_Melee_Attack_Punch_A";
        case UNARMED_MELEE_ATTACK_PUNCH_B -> "Unarmed_Melee_Attack_Punch_B";
        case UNARMED_MELEE_ATTACK_KICK -> "Unarmed_Melee_Attack_Kick";
        case BLOCK -> "Block";
        case BLOCKING -> "Blocking";
        case BLOCK_HIT -> "Block_Hit";
        case BLOCK_ATTACK -> "Block_Attack";
        case RANGED_AIMING_1H -> "1H_Ranged_Aiming";
        case RANGED_SHOOT_1H -> "1H_Ranged_Shoot";
        case RANGED_SHOOTING_1H -> "1H_Ranged_Shooting";
        case RANGED_RELOAD_1H -> "1H_Ranged_Reload";
        case RANGED_AIMING_2H -> "2H_Ranged_Aiming";
        case RANGED_SHOOT_2H -> "2H_Ranged_Shoot";
        case RANGED_SHOOTING_2H -> "2H_Ranged_Shooting";
        case RANGED_RELOAD_2H -> "2H_Ranged_Reload";
        case SPELLCAST_SHOOT -> "Spellcast_Shoot";
        case SPELLCAST_RAISE -> "Spellcast_Raise";
        case SPELLCAST_LONG -> "Spellcast_Long";
        case SPELLCASTING -> "Spellcasting";
        case LIE_DOWN -> "Lie_Down";
        case LIE_IDLE -> "Lie_Idle";
        case LIE_POSE -> "Lie_Pose";
        case LIE_STAND_UP -> "Lie_StandUp";
        case SIT_CHAIR_DOWN -> "Sit_Chair_Down";
        case SIT_CHAIR_IDLE -> "Sit_Chair_Idle";
        case SIT_CHAIR_POSE -> "Sit_Chair_Pose";
        case SIT_CHAIR_STAND_UP -> "Sit_Chair_StandUp";
        case SIT_FLOOR_DOWN -> "Sit_Floor_Down";
        case SIT_FLOOR_IDLE -> "Sit_Floor_Idle";
        case SIT_FLOOR_POSE -> "Sit_Floor_Pose";
        case SIT_FLOOR_STAND_UP -> "Sit_Floor_StandUp";
    };
}



}
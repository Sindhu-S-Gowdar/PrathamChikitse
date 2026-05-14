package com.example.prathamchikitse.data.repository

import com.example.prathamchikitse.data.model.EmergencyGuide
import com.example.prathamchikitse.data.model.Hospital
import com.example.prathamchikitse.language.AppLanguage

object FirstAidRepository {

    private val emergencyGuidesEnglish = listOf(
        guide(
            "snake_bite", "Snake Bite", "#EF5350",
            "Move the person away from the snake and keep them calm to slow venom spread.",
            "Lay the person down and keep the bitten limb still and below heart level.",
            "Remove rings, bangles, shoes, or tight clothing before swelling begins.",
            "Clean the bite gently with water and cover with a clean dry dressing.",
            "Call emergency services and transport urgently to a hospital with antivenom care.",
            dos = listOf(
                "Do reassure and monitor breathing, pulse, and consciousness.",
                "Do immobilize the limb with a splint if possible.",
                "Do note the time of bite for doctors.",
                "Do photograph the snake only if it is completely safe.",
                "Do keep the patient fasting in case procedures are needed."
            ),
            donts = listOf(
                "Do not cut, suck, or squeeze the wound.",
                "Do not apply ice, chemicals, or herbal pastes.",
                "Do not use a tight tourniquet.",
                "Do not give alcohol, caffeine, or smoking products.",
                "Do not let the patient walk or run."
            )
        ),
        guide(
            "heart_attack", "Heart Attack", "#AB47BC",
            "Call emergency medical help immediately.",
            "Help the person sit in a half-sitting position and rest.",
            "Loosen tight clothes around the chest and neck.",
            "If prescribed by a doctor, assist with their emergency medicine.",
            "If unresponsive and not breathing normally, start CPR and use AED if available.",
            dos = listOf(
                "Do stay with the person and keep them calm.",
                "Do monitor breathing continuously.",
                "Do keep emergency contacts informed.",
                "Do note symptom start time.",
                "Do prepare hospital documents if available."
            ),
            donts = listOf(
                "Do not ignore chest pain lasting more than a few minutes.",
                "Do not delay calling emergency care.",
                "Do not let the person walk around.",
                "Do not give heavy food or drinks.",
                "Do not panic; act quickly and steadily."
            )
        ),
        guide(
            "choking", "Choking", "#5C6BC0",
            "Ask whether the person can cough or speak.",
            "If they can cough, encourage strong repeated coughing.",
            "If severe airway blockage, give 5 firm back blows.",
            "Give 5 abdominal thrusts and alternate with back blows.",
            "If unresponsive, start CPR and call emergency services.",
            dos = listOf(
                "Do call for help early.",
                "Do support infants with infant-specific technique.",
                "Do remove visible object only if clearly seen.",
                "Do continue cycles until object is expelled or help arrives.",
                "Do seek medical checkup after severe choking episode."
            ),
            donts = listOf(
                "Do not do blind finger sweeps.",
                "Do not slap a mildly choking person who can cough well.",
                "Do not stop too early if severe blockage remains.",
                "Do not give water during active choking.",
                "Do not leave the person alone."
            )
        ),
        guide(
            "burns", "Burns", "#26A69A",
            "Stop the burning source and ensure scene safety.",
            "Cool the burn under cool running water for at least 20 minutes.",
            "Remove jewelry and tight clothing near the burn, if not stuck.",
            "Cover with sterile non-stick dressing or clean cloth.",
            "Seek urgent care for large, deep, electrical, facial, or chemical burns.",
            dos = listOf(
                "Do cool as early as possible.",
                "Do keep the person warm overall while cooling only burn area.",
                "Do elevate burned limb if possible.",
                "Do monitor for shock signs.",
                "Do check tetanus protection later."
            ),
            donts = listOf(
                "Do not apply butter, oil, toothpaste, or powders.",
                "Do not burst blisters.",
                "Do not peel off stuck clothing.",
                "Do not use ice directly on burn.",
                "Do not delay hospital care for major burns."
            )
        ),
        guide(
            "fracture", "Fracture", "#FFA726",
            "Keep the person still and support the injured area.",
            "Immobilize with a padded splint in the position found.",
            "Apply cold pack wrapped in cloth to reduce swelling.",
            "Check circulation, sensation, and movement beyond injury.",
            "Transport gently for X-ray and expert treatment.",
            dos = listOf(
                "Do treat open wounds with sterile dressing.",
                "Do elevate injured limb if safe.",
                "Do watch for severe pain or numbness.",
                "Do call emergency help for major deformity.",
                "Do remove rings near hand fractures early."
            ),
            donts = listOf(
                "Do not force bone back into place.",
                "Do not straighten severe deformities.",
                "Do not allow unnecessary movement.",
                "Do not massage the fracture site.",
                "Do not give food before potential surgery."
            )
        ),
        guide(
            "drowning", "Drowning", "#29B6F6",
            "Ensure rescuer safety and remove person from water.",
            "Check responsiveness and breathing immediately.",
            "Start rescue breaths and CPR if not breathing normally.",
            "Call emergency services and continue support.",
            "Keep person warm and monitor continuously.",
            dos = listOf(
                "Do prioritize airway and breathing first.",
                "Do remove wet clothes and cover with blanket.",
                "Do place in recovery position if breathing but unconscious.",
                "Do observe for delayed breathing trouble.",
                "Do seek medical assessment even after recovery."
            ),
            donts = listOf(
                "Do not enter unsafe water without support.",
                "Do not assume person is fine after coughing only.",
                "Do not delay CPR when needed.",
                "Do not give alcohol.",
                "Do not leave them unattended."
            )
        ),
        guide(
            "electric_shock", "Electric Shock", "#FF7043",
            "Turn off electrical source before touching the victim.",
            "Use dry non-conductive object to separate if needed.",
            "Check breathing, pulse, and consciousness.",
            "Start CPR if required and call emergency care.",
            "Cover visible burns and seek urgent hospital evaluation.",
            dos = listOf(
                "Do ensure scene is electrically safe first.",
                "Do monitor continuously until help arrives.",
                "Do look for both entry and exit burns.",
                "Do keep patient lying down and calm.",
                "Do seek care even if symptoms seem mild."
            ),
            donts = listOf(
                "Do not touch victim while current may still flow.",
                "Do not use metal or wet objects.",
                "Do not apply ointments on electrical burns.",
                "Do not move if spinal injury suspected.",
                "Do not ignore chest pain or confusion afterward."
            )
        ),
        guide(
            "poisoning", "Poisoning", "#8D6E63",
            "Identify possible poison and route (swallowed, inhaled, skin, eye).",
            "Call poison control or emergency service immediately.",
            "If unconscious but breathing, place in recovery position.",
            "If chemical on skin/eyes, rinse with running water for 15-20 minutes.",
            "Take medicine strip/container/photo to hospital.",
            dos = listOf(
                "Do keep airway clear and monitor breathing.",
                "Do gather exact timing and amount if known.",
                "Do follow poison expert instructions strictly.",
                "Do preserve samples for doctors if safe.",
                "Do transport quickly when symptoms are serious."
            ),
            donts = listOf(
                "Do not induce vomiting unless advised.",
                "Do not give milk, lemon, or home remedies blindly.",
                "Do not force oral fluids to drowsy person.",
                "Do not delay emergency consultation.",
                "Do not discard poison container before evaluation."
            )
        ),
        guide(
            "fever", "Fever", "#66BB6A",
            "Measure temperature and evaluate associated symptoms.",
            "Encourage oral fluids and adequate rest.",
            "Use age-appropriate fever medicine as advised.",
            "Sponge with lukewarm water if uncomfortable.",
            "Seek care for persistent high fever or warning signs.",
            dos = listOf(
                "Do keep patient hydrated with water/ORS.",
                "Do keep clothes light and room ventilated.",
                "Do monitor children and elderly closely.",
                "Do note fever pattern and associated symptoms.",
                "Do seek urgent care for seizures, rash, or breathing trouble."
            ),
            donts = listOf(
                "Do not overdress with heavy blankets.",
                "Do not give aspirin to children.",
                "Do not overuse antibiotics without prescription.",
                "Do not ignore dehydration signs.",
                "Do not delay doctor review for prolonged fever."
            )
        ),
        guide(
            "bleeding", "Bleeding", "#EC407A",
            "Apply firm direct pressure using clean cloth or dressing.",
            "Elevate injured area if no fracture suspected.",
            "Add more dressing layers if soaked; keep pressure ongoing.",
            "Bandage firmly once bleeding is controlled.",
            "Seek emergency help for heavy or persistent bleeding.",
            dos = listOf(
                "Do use gloves if available.",
                "Do treat for shock by laying flat and keeping warm.",
                "Do monitor pulse and consciousness.",
                "Do call emergency services for spurting blood.",
                "Do keep pressure until professionals take over."
            ),
            donts = listOf(
                "Do not remove deeply embedded objects.",
                "Do not repeatedly lift first dressing to check.",
                "Do not use untrained tourniquet use.",
                "Do not delay help in major blood loss.",
                "Do not give food if surgery may be needed."
            )
        ),
        guide(
            "eye_injury", "Eye Injury", "#42A5F5",
            "Avoid rubbing or pressing the injured eye.",
            "For chemical splash, rinse with clean running water for at least 15 minutes.",
            "Shield eye lightly with clean cup or dressing.",
            "If object is embedded, keep both eyes still and covered.",
            "Seek urgent ophthalmology evaluation.",
            dos = listOf(
                "Do wash hands before helping.",
                "Do keep patient calm and limit eye movement.",
                "Do transport quickly for specialist care.",
                "Do protect from bright light if painful.",
                "Do report exact cause (chemical, metal, trauma)."
            ),
            donts = listOf(
                "Do not remove embedded objects.",
                "Do not apply pressure patch tightly.",
                "Do not use unprescribed eye drops.",
                "Do not delay emergency care for vision changes.",
                "Do not allow eye rubbing."
            )
        ),
        guide(
            "allergic_reaction", "Allergic Reaction", "#7E57C2",
            "Identify severe signs: swelling, breathing trouble, wheeze, faintness.",
            "Give prescribed epinephrine auto-injector immediately if anaphylaxis suspected.",
            "Call emergency services at once.",
            "Lay patient flat with legs raised unless severe breathlessness.",
            "Monitor airway and be ready for CPR.",
            dos = listOf(
                "Do repeat epinephrine as medically advised if symptoms persist.",
                "Do remove likely allergen source if possible.",
                "Do keep patient under observation.",
                "Do carry allergy history to hospital.",
                "Do seek hospital review even after improvement."
            ),
            donts = listOf(
                "Do not delay epinephrine for severe symptoms.",
                "Do not let patient stand or walk suddenly.",
                "Do not give food/drink in severe reaction.",
                "Do not leave patient alone.",
                "Do not rely only on antihistamine in anaphylaxis."
            )
        ),
        guide(
            "fainting", "Fainting", "#26C6DA",
            "Lay the person flat and raise legs 20-30 cm.",
            "Loosen tight clothing and ensure fresh air.",
            "Check breathing and pulse.",
            "Turn to side if vomiting occurs.",
            "If not recovering quickly, seek medical help.",
            dos = listOf(
                "Do reassure after regaining consciousness.",
                "Do allow rest for several minutes before standing.",
                "Do hydrate once fully alert.",
                "Do look for triggers like heat or missed meals.",
                "Do seek checkup if recurrent episodes occur."
            ),
            donts = listOf(
                "Do not force immediate standing.",
                "Do not splash aggressively with cold water.",
                "Do not give oral fluids while unconscious.",
                "Do not ignore chest pain or head injury with fainting.",
                "Do not leave alone right after recovery."
            )
        ),
        guide(
            "seizure", "Seizure", "#D4E157",
            "Protect from injury by clearing nearby dangerous objects.",
            "Place something soft under the head.",
            "Do not restrain movements; allow seizure to pass.",
            "After jerking stops, place in recovery position.",
            "Time the seizure and call emergency if >5 minutes or repeated.",
            dos = listOf(
                "Do stay calm and stay with the person.",
                "Do check breathing after seizure.",
                "Do loosen tight neck clothing.",
                "Do seek help for first-time seizure or injury.",
                "Do document duration and symptoms for doctor."
            ),
            donts = listOf(
                "Do not put anything in the mouth.",
                "Do not hold person down forcefully.",
                "Do not give food, drink, or pills until fully alert.",
                "Do not panic if seizure is short and self-limited.",
                "Do not ignore prolonged confusion afterward."
            )
        ),
        guide(
            "nosebleed", "Nosebleed", "#FFCA28",
            "Sit upright and lean slightly forward.",
            "Pinch soft part of nose continuously for 10-15 minutes.",
            "Apply cold compress over nasal bridge.",
            "Continue pressure for another 10 minutes if needed.",
            "Seek care if persistent bleeding or recurrent episodes.",
            dos = listOf(
                "Do breathe through the mouth while pinching.",
                "Do spit out blood instead of swallowing.",
                "Do rest quietly after bleeding stops.",
                "Do seek care for blood-thinner users.",
                "Do keep indoor air humidified in dry weather."
            ),
            donts = listOf(
                "Do not tilt head backward.",
                "Do not blow or pick nose soon after.",
                "Do not lie flat during active bleeding.",
                "Do not release pressure too early.",
                "Do not ignore bleeding after facial trauma."
            )
        ),
        guide(
            "sprain", "Sprain", "#9CCC65",
            "Rest the injured joint and stop activity.",
            "Apply ice pack wrapped in cloth for 15-20 minutes repeatedly.",
            "Use compression bandage for support.",
            "Elevate the limb above heart level.",
            "Seek medical care if severe swelling, deformity, or inability to bear weight.",
            dos = listOf(
                "Do follow RICE in first 24-48 hours.",
                "Do remove rings from swollen extremity early.",
                "Do use supportive brace if advised.",
                "Do start gentle mobility later as pain improves.",
                "Do check for fracture if pain is severe."
            ),
            donts = listOf(
                "Do not apply direct heat in first 48 hours.",
                "Do not massage acutely injured tissue.",
                "Do not return to sports too early.",
                "Do not ignore persistent instability.",
                "Do not wrap compression too tightly."
            )
        ),
        guide(
            "dog_bite", "Dog Bite", "#8D6E63",
            "Wash wound thoroughly with soap and running water for 10-15 minutes.",
            "Apply antiseptic and cover with clean dressing.",
            "Control bleeding with gentle direct pressure.",
            "Seek urgent care for rabies risk and tetanus protection.",
            "Observe wound daily for infection signs.",
            dos = listOf(
                "Do get medical care even for small puncture wounds.",
                "Do record dog details and vaccination status if available.",
                "Do keep wound clean and dry.",
                "Do complete prescribed vaccine/course.",
                "Do return urgently if fever, redness, or swelling worsens."
            ),
            donts = listOf(
                "Do not ignore minor-looking bites.",
                "Do not close deep dirty wounds at home.",
                "Do not stop rabies treatment midway.",
                "Do not apply irritant powders or pastes.",
                "Do not delay treatment after stray animal bites."
            )
        ),
        guide(
            "head_injury", "Head Injury", "#78909C",
            "Check responsiveness and breathing first.",
            "Keep head and neck aligned and minimize movement.",
            "Apply cold pack for minor swelling (wrapped in cloth).",
            "Observe for warning signs like vomiting, severe headache, confusion, drowsiness.",
            "Call emergency for unconsciousness, seizures, weakness, or worsening symptoms.",
            dos = listOf(
                "Do monitor closely for 24 hours.",
                "Do seek immediate care for children and elderly with concerning symptoms.",
                "Do keep patient awake/assessed periodically after minor injury.",
                "Do use emergency transport for severe trauma.",
                "Do report blood thinner use to doctors."
            ),
            donts = listOf(
                "Do not shake the person.",
                "Do not allow sports or heavy activity early.",
                "Do not give alcohol or sedatives.",
                "Do not ignore repeated vomiting.",
                "Do not move person if spinal injury suspected unless danger exists."
            )
        ),
        guide(
            "asthma_attack", "Asthma Attack", "#42A5F5",
            "Help the person sit upright and reassure them.",
            "Assist with quick-relief inhaler through spacer if available.",
            "Give repeated puffs as per asthma action plan.",
            "Call emergency if symptoms do not improve quickly.",
            "Monitor breathing, speech, and consciousness continuously.",
            dos = listOf(
                "Do keep rescue inhaler accessible.",
                "Do use spacer for better medicine delivery.",
                "Do loosen tight clothing.",
                "Do follow personalized asthma plan.",
                "Do seek medical review after severe attack."
            ),
            donts = listOf(
                "Do not lay patient flat.",
                "Do not delay emergency call in severe distress.",
                "Do not leave the person alone.",
                "Do not force food or drink during breathlessness.",
                "Do not ignore bluish lips or inability to speak."
            )
        ),
        guide(
            "diabetic_emergency", "Diabetic Emergency", "#F06292",
            "Check responsiveness and blood sugar if possible.",
            "If conscious and low sugar suspected, give fast sugar (glucose, juice, sugar water).",
            "Reassess after 10-15 minutes and repeat fast sugar if needed.",
            "After improvement, give longer-acting snack (biscuit/bread).",
            "Call emergency for unconsciousness, seizures, or no improvement.",
            dos = listOf(
                "Do carry glucose source for known diabetics.",
                "Do monitor closely for recurrence.",
                "Do keep diabetes ID information available.",
                "Do place unconscious patient in recovery position.",
                "Do arrange urgent hospital evaluation for severe episodes."
            ),
            donts = listOf(
                "Do not give food/drink to unconscious person.",
                "Do not inject insulin in suspected low sugar episode.",
                "Do not delay emergency help in confusion/seizure.",
                "Do not leave patient alone after temporary recovery.",
                "Do not ignore repeated low-sugar symptoms."
            )
        )
    )

    private val emergencyGuidesKannada = listOf(
        guide(
            "snake_bite", "ಹಾವಿನ ಕಚ್ಚು", "#EF5350",
            "ಹಾವು ಇರುವ ಸ್ಥಳದಿಂದ ವ್ಯಕ್ತಿಯನ್ನು ದೂರ ಮಾಡಿ ಮತ್ತು ವಿಷ ವೇಗವಾಗಿ ಹರಡದಂತೆ ಶಾಂತವಾಗಿರಿಸಿ.",
            "ವ್ಯಕ್ತಿಯನ್ನು ಮಲಗಿಸಿ ಮತ್ತು ಕಚ್ಚಿದ ಅಂಗವನ್ನು ಹೃದಯ ಮಟ್ಟಕ್ಕಿಂತ ಕೆಳಗೆ ಸ್ಥಿರವಾಗಿ ಇಡಿ.",
            "ಉಬ್ಬರ ಶುರುವಾಗುವ ಮೊದಲು ಉಂಗುರ, ಬಳೆ, ಶೂ ಅಥವಾ ಬಿಗಿಯಾದ ಬಟ್ಟೆಗಳನ್ನು ತೆಗೆದುಹಾಕಿ.",
            "ಕಚ್ಚಿದ ಸ್ಥಳವನ್ನು ನೀರಿನಿಂದ ಮೃದುವಾಗಿ ಸ್ವಚ್ಛಗೊಳಿಸಿ ಮತ್ತು ಸ್ವಚ್ಛ ಒಣ ಪಟ್ಟಿಯಿಂದ ಮುಚ್ಚಿ.",
            "ತುರ್ತು ವೈದ್ಯಕೀಯ ಸಹಾಯ ಕರೆ ಮಾಡಿ ಮತ್ತು ಆಂಟಿ-ವೆನಮ್ ಇರುವ ಆಸ್ಪತ್ರೆಗೆ ತಕ್ಷಣ ಕರೆದೊಯ್ಯಿ.",
            dos = listOf(
                "ಉಸಿರಾಟ, ನಾಡಿ ಮತ್ತು ಜಾಗೃತಿಯನ್ನು ಗಮನಿಸಿ ಭರವಸೆ ನೀಡಿ.",
                "ಸಾಧ್ಯವಾದರೆ ಅಂಗವನ್ನು ಸ್ಪ್ಲಿಂಟ್ ಬಳಸಿ ಸ್ಥಿರಗೊಳಿಸಿ.",
                "ವೈದ್ಯರಿಗೆ ಕಚ್ಚಿದ ಸಮಯವನ್ನು ದಾಖಲಿಸಿ.",
                "ಸುರಕ್ಷಿತವಾಗಿದ್ದರೆ ಮಾತ್ರ ಹಾವಿನ ಫೋಟೋ ತೆಗೆದುಕೊಳ್ಳಿ.",
                "ವೈದ್ಯಕೀಯ ಕ್ರಮಗಳವರೆಗೆ ರೋಗಿಯನ್ನು ಉಪವಾಸದಲ್ಲಿರಿಸಿ."
            ),
            donts = listOf(
                "ಗಾಯವನ್ನು ಕತ್ತರಿಸಬೇಡಿ, ಹೀರುವುದಿಲ್ಲ, ಒತ್ತಬೇಡಿ.",
                "ಐಸ್, ರಾಸಾಯನಿಕ ಅಥವಾ ಹರ್ಬಲ್ ಪೇಸ್ಟ್ ಹಚ್ಚಬೇಡಿ.",
                "ಬಿಗಿಯಾದ ಟೂರ್‌ನಿಕೆಟ್ ಬಳಸಬೇಡಿ.",
                "ಮದ್ಯ, ಕ್ಯಾಫೀನ್ ಅಥವಾ ಧೂಮಪಾನ ನೀಡಬೇಡಿ.",
                "ರೋಗಿಯನ್ನು ನಡೆಯಲು ಅಥವಾ ಓಡಲು ಬಿಡಬೇಡಿ."
            )
        ),
        guide(
            "heart_attack", "ಹೃದಯಾಘಾತ", "#AB47BC",
            "ತಕ್ಷಣ ತುರ್ತು ವೈದ್ಯಕೀಯ ಸಹಾಯಕ್ಕೆ ಕರೆ ಮಾಡಿ.",
            "ವ್ಯಕ್ತಿಯನ್ನು ಅರ್ಧ ಕುಳಿತ ಸ್ಥಿತಿಯಲ್ಲಿ ಇರಿಸಿ ವಿಶ್ರಾಂತಿ ಕೊಡಿಸಿ.",
            "ಛಾತಿ ಮತ್ತು ಕುತ್ತಿಗೆಯ ಸುತ್ತ ಬಿಗಿಯಾದ ಬಟ್ಟೆಯನ್ನು ಸಡಿಲಿಸಿ.",
            "ವೈದ್ಯರು ಸೂಚಿಸಿದ್ದರೆ ತುರ್ತು ಔಷಧಿ ತೆಗೆದುಕೊಳ್ಳಲು ಸಹಾಯ ಮಾಡಿ.",
            "ಉಸಿರಾಟ ಇಲ್ಲದಿದ್ದರೆ CPR ಪ್ರಾರಂಭಿಸಿ ಹಾಗೂ AED ಇದ್ದರೆ ಬಳಸಿ.",
            dos = listOf(
                "ವ್ಯಕ್ತಿಯ ಜೊತೆ ಇರಿ ಮತ್ತು ಶಾಂತಪಡಿಸಿ.",
                "ಉಸಿರಾಟವನ್ನು ನಿರಂತರವಾಗಿ ಗಮನಿಸಿ.",
                "ಕುಟುಂಬ/ತುರ್ತು ಸಂಪರ್ಕಕ್ಕೆ ಮಾಹಿತಿ ನೀಡಿ.",
                "ಲಕ್ಷಣ ಆರಂಭವಾದ ಸಮಯವನ್ನು ದಾಖಲಿಸಿ.",
                "ಆಸ್ಪತ್ರೆ ದಾಖಲೆಗಳು ಲಭ್ಯವಿದ್ದರೆ ಸಿದ್ಧಪಡಿಸಿ."
            ),
            donts = listOf(
                "ಕೆಲವು ನಿಮಿಷಕ್ಕಿಂತ ಹೆಚ್ಚು ಇರುವ ಛಾತಿ ನೋವನ್ನು ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ.",
                "ತುರ್ತು ಕರೆ ಮಾಡಲು ವಿಳಂಬ ಮಾಡಬೇಡಿ.",
                "ವ್ಯಕ್ತಿಯನ್ನು ನಡೆದು ತಿರುಗಲು ಬಿಡಬೇಡಿ.",
                "ಭಾರವಾದ ಆಹಾರ ಅಥವಾ ಪಾನೀಯ ಕೊಡಬೇಡಿ.",
                "ಗಾಬರಿಯಾಗಬೇಡಿ; ಶೀಘ್ರವಾಗಿ ಕ್ರಮ ಕೈಗೊಳ್ಳಿ."
            )
        ),
        guide(
            "choking", "ಉಸಿರುಗಟ್ಟಿಕೆ", "#5C6BC0",
            "ವ್ಯಕ್ತಿಗೆ ಕೆಮ್ಮಲು ಅಥವಾ ಮಾತನಾಡಲು ಆಗುತ್ತಿದೆಯೇ ಕೇಳಿ.",
            "ಕೆಮ್ಮಲು ಆಗುತ್ತಿದ್ದರೆ ಬಲವಾಗಿ ಮತ್ತೆ ಮತ್ತೆ ಕೆಮ್ಮಲು ಹೇಳಿ.",
            "ತೀವ್ರ ಅಡಚಣೆ ಇದ್ದರೆ ಬೆನ್ನಿಗೆ 5 ಬಲವಾದ ಹೊಡೆತ ನೀಡಿ.",
            "5 ಹೊಟ್ಟೆ ಒತ್ತುವಿಕೆ ನೀಡಿ, ನಂತರ ಮತ್ತೆ ಬೆನ್ನಿಗೆ ಹೊಡೆತ ನೀಡಿ.",
            "ಪ್ರತಿಕ್ರಿಯೆ ಇಲ್ಲದಿದ್ದರೆ CPR ಪ್ರಾರಂಭಿಸಿ ಮತ್ತು ತುರ್ತು ಸೇವೆಗೆ ಕರೆ ಮಾಡಿ.",
            dos = listOf(
                "ಸಹಾಯಕ್ಕಾಗಿ ಬೇಗ ಕರೆ ಮಾಡಿ.",
                "ಮಕ್ಕಳಿಗೆ ಅವರ ವಯಸ್ಸಿಗೆ ತಕ್ಕ ವಿಧಾನ ಬಳಸಿ.",
                "ಸ್ಪಷ್ಟವಾಗಿ ಕಾಣುವ ವಸ್ತುವನ್ನು ಮಾತ್ರ ತೆಗೆದುಹಾಕಿ.",
                "ಅಡಚಣೆ ಹೋಗುವವರೆಗೂ ಕ್ರಮ ಮುಂದುವರಿಸಿ.",
                "ತೀವ್ರ ಘಟನೆಯ ಬಳಿಕ ವೈದ್ಯಕೀಯ ಪರಿಶೀಲನೆ ಮಾಡಿಸಿ."
            ),
            donts = listOf(
                "ಕಾಣದ ವಸ್ತುವನ್ನು ಬೆರಳು ಹಾಕಿ ಹುಡುಕಬೇಡಿ.",
                "ಕೆಮ್ಮುತ್ತಿರುವ ವ್ಯಕ್ತಿಯನ್ನು ಅನಾವಶ್ಯಕವಾಗಿ ಹೊಡೆಯಬೇಡಿ.",
                "ತೀವ್ರ ಅಡಚಣೆ ಇದ್ದಾಗ ಮಧ್ಯದಲ್ಲೇ ನಿಲ್ಲಿಸಬೇಡಿ.",
                "ಉಸಿರುಗಟ್ಟುವಾಗ ನೀರು ಕೊಡಬೇಡಿ.",
                "ವ್ಯಕ್ತಿಯನ್ನು ಒಬ್ಬರನ್ನೇ ಬಿಡಬೇಡಿ."
            )
        ),
        guide(
            "burns", "ಸುಟ್ಟ ಗಾಯ", "#26A69A",
            "ಸುಡುವ ಮೂಲವನ್ನು ನಿಲ್ಲಿಸಿ ಮತ್ತು ಸ್ಥಳದ ಸುರಕ್ಷತೆ ಖಚಿತಪಡಿಸಿ.",
            "ಗಾಯದ ಮೇಲೆ ತಂಪು ಹರಿಯುವ ನೀರನ್ನು ಕನಿಷ್ಠ 20 ನಿಮಿಷ ಹರಿಸಿ.",
            "ಅಂಟಿಕೊಂಡಿಲ್ಲದಿದ್ದರೆ ಹತ್ತಿರದ ಆಭರಣ/ಬಿಗಿ ಬಟ್ಟೆ ತೆಗೆದುಹಾಕಿ.",
            "ಸ್ಟೆರೈಲ್ ನಾನ್-ಸ್ಟಿಕ್ ಡ್ರೆಸ್ಸಿಂಗ್ ಅಥವಾ ಸ್ವಚ್ಛ ಬಟ್ಟೆಯಿಂದ ಮುಚ್ಚಿ.",
            "ದೊಡ್ಡ, ಆಳವಾದ, ವಿದ್ಯುತ್, ಮುಖ ಅಥವಾ ರಾಸಾಯನಿಕ ಸುಟ್ಟ ಗಾಯಕ್ಕೆ ತಕ್ಷಣ ಆಸ್ಪತ್ರೆಗೆ ಹೋಗಿ.",
            dos = listOf(
                "ಸಾಧ್ಯವಾದಷ್ಟು ಬೇಗ ತಂಪುಗೊಳಿಸುವಿಕೆ ಪ್ರಾರಂಭಿಸಿ.",
                "ಗಾಯ ತಂಪುಗೊಳಿಸುವಾಗ ಉಳಿದ ದೇಹವನ್ನು ಬೆಚ್ಚಗೆ ಇಡಿ.",
                "ಸಾಧ್ಯವಾದರೆ ಸುಟ್ಟ ಅಂಗವನ್ನು ಎತ್ತಿ ಇಡಿ.",
                "ಶಾಕ್ ಲಕ್ಷಣಗಳನ್ನು ಗಮನಿಸಿ.",
                "ನಂತರ ಟೆಟನಸ್ ರಕ್ಷಣೆ ಕುರಿತು ಪರಿಶೀಲಿಸಿ."
            ),
            donts = listOf(
                "ಬೆಣ್ಣೆ, ಎಣ್ಣೆ, ಟೂತ್‌ಪೇಸ್ಟ್ ಅಥವಾ ಪುಡಿ ಹಚ್ಚಬೇಡಿ.",
                "ಬ್ಲಿಸ್ಟರ್‌ಗಳನ್ನು ಒಡೆಬೇಡಿ.",
                "ಅಂಟಿದ ಬಟ್ಟೆಯನ್ನು ಬಲವಂತವಾಗಿ ತೆಗೆಯಬೇಡಿ.",
                "ಐಸ್ ಅನ್ನು ನೇರವಾಗಿ ಹಚ್ಚಬೇಡಿ.",
                "ತೀವ್ರ ಸುಟ್ಟ ಗಾಯಕ್ಕೆ ಆಸ್ಪತ್ರೆಗೆ ಹೋಗುವುದನ್ನು ವಿಳಂಬಿಸಬೇಡಿ."
            )
        ),
        guide(
            "fracture", "ಎಲುಬು ಮುರಿತ", "#FFA726",
            "ವ್ಯಕ್ತಿಯನ್ನು ಅಚಲವಾಗಿರಿಸಿ ಮತ್ತು ಗಾಯಗೊಂಡ ಭಾಗಕ್ಕೆ ಬೆಂಬಲ ನೀಡಿ.",
            "ಕಂಡ ಸ್ಥಿತಿಯಲ್ಲೇ ಪದರಿತ ಸ್ಪ್ಲಿಂಟ್ ಬಳಸಿ ಸ್ಥಿರಗೊಳಿಸಿ.",
            "ಒದ್ದೆ ಬಟ್ಟೆಯಲ್ಲಿ ಸುತ್ತಿದ ತಣ್ಣೀರು/ಐಸ್ ಪ್ಯಾಕ್ ಬಳಸಿ ಉಬ್ಬರವನ್ನ ಕಡಿಮೆ ಮಾಡಿ.",
            "ಗಾಯದ ಕೆಳಭಾಗದಲ್ಲಿ ರಕ್ತಸಂಚಾರ, ಸಂವೇದನೆ, ಚಲನೆಯನ್ನು ಪರಿಶೀಲಿಸಿ.",
            "ಎಕ್ಸ್‌ರೇ ಮತ್ತು ತಜ್ಞ ಚಿಕಿತ್ಸೆಗೆ ನಿಧಾನವಾಗಿ ಕರೆದೊಯ್ಯಿ.",
            dos = listOf(
                "ತೆರೆದ ಗಾಯವನ್ನು ಸ್ಟೆರೈಲ್ ಪಟ್ಟಿಯಿಂದ ಮುಚ್ಚಿ.",
                "ಸುರಕ್ಷಿತವಾಗಿದ್ದರೆ ಅಂಗವನ್ನು ಎತ್ತಿ ಇಡಿ.",
                "ತೀವ್ರ ನೋವು ಅಥವಾ ಸುಣ್ಣಾಗುವಿಕೆ ಗಮನಿಸಿ.",
                "ಭಾರಿ ವಿಕೃತಿ ಇದ್ದರೆ ತುರ್ತು ಸಹಾಯಕ್ಕೆ ಕರೆ ಮಾಡಿ.",
                "ಕೈ ಮುರಿತದ ಬಳಿ ಉಂಗುರಗಳನ್ನು ಬೇಗ ತೆಗೆದುಹಾಕಿ."
            ),
            donts = listOf(
                "ಎಲುಬನ್ನು ಬಲವಂತವಾಗಿ ಹಿಂತಿರುಗಿಸಬೇಡಿ.",
                "ತೀವ್ರ ವಿಕೃತಿಯನ್ನು ನೇರಗೊಳಿಸಲು ಪ್ರಯತ್ನಿಸಬೇಡಿ.",
                "ಅನಗತ್ಯ ಚಲನೆಗೆ ಅವಕಾಶ ಕೊಡಬೇಡಿ.",
                "ಮುರಿದ ಸ್ಥಳವನ್ನು ಮಸಾಜ್ ಮಾಡಬೇಡಿ.",
                "ಶಸ್ತ್ರಚಿಕಿತ್ಸೆ ಸಾಧ್ಯತೆಯಿದ್ದರೆ ಆಹಾರ ಕೊಡಬೇಡಿ."
            )
        ),
        guide(
            "drowning", "ಮುಳುಗು", "#29B6F6",
            "ರಕ್ಷಕರ ಸುರಕ್ಷತೆ ಖಚಿತಪಡಿಸಿ ಮತ್ತು ವ್ಯಕ್ತಿಯನ್ನು ನೀರಿನಿಂದ ಹೊರತೆಗೆದು.",
            "ತಕ್ಷಣ ಪ್ರತಿಕ್ರಿಯೆ ಮತ್ತು ಉಸಿರಾಟ ಪರಿಶೀಲಿಸಿ.",
            "ಉಸಿರಾಟ ಸಾಮಾನ್ಯವಾಗಿಲ್ಲದಿದ್ದರೆ ರೆಸ್ಕ್ಯೂ ಉಸಿರು ಮತ್ತು CPR ಪ್ರಾರಂಭಿಸಿ.",
            "ತುರ್ತು ಸೇವೆಗೆ ಕರೆ ಮಾಡಿ ಮತ್ತು ಸಹಾಯ ಮುಂದುವರಿಸಿ.",
            "ವ್ಯಕ್ತಿಯನ್ನು ಬೆಚ್ಚಗೆ ಇಟ್ಟು ನಿರಂತರವಾಗಿ ಗಮನಿಸಿ.",
            dos = listOf(
                "ಮೊದಲು ಶ್ವಾಸಮಾರ್ಗ ಮತ್ತು ಉಸಿರಾಟಕ್ಕೆ ಆದ್ಯತೆ ನೀಡಿ.",
                "ಒದ್ದೆಯಾದ ಬಟ್ಟೆ ತೆಗೆದು ಕಂಬಳಿಯಿಂದ ಮುಚ್ಚಿ.",
                "ಉಸಿರಾಟ ಇದ್ದರೂ ಅಜ್ಞಾನಸ್ಥಿತಿಯಲ್ಲಿ ರಿಕವರಿ ಸ್ಥಿತಿಯಲ್ಲಿ ಇಡಿ.",
                "ನಂತರದ ಉಸಿರಾಟ ಸಮಸ್ಯೆಗಾಗಿ ಗಮನಿಸಿ.",
                "ಚೇತರಿಸಿಕೊಂಡರೂ ವೈದ್ಯಕೀಯ ಪರಿಶೀಲನೆ ಮಾಡಿಸಿ."
            ),
            donts = listOf(
                "ಅಸುರಕ್ಷಿತ ನೀರಿಗೆ ರಕ್ಷಣೆ ಇಲ್ಲದೆ ಇಳಿಯಬೇಡಿ.",
                "ಕೆಮ್ಮಿದ ಮೇಲೆ ಮಾತ್ರ ಸರಿಯಾಗಿದೆ ಎಂದು ಊಹಿಸಬೇಡಿ.",
                "CPR ಅಗತ್ಯವಿದ್ದರೆ ವಿಳಂಬಿಸಬೇಡಿ.",
                "ಮದ್ಯ ಕೊಡಬೇಡಿ.",
                "ವ್ಯಕ್ತಿಯನ್ನು ಒಂಟಿಯಾಗಿ ಬಿಡಬೇಡಿ."
            )
        ),
        guide(
            "electric_shock", "ವಿದ್ಯುತ್ ಆಘಾತ", "#FF7043",
            "ಬಲೆಗೆ ಮುನ್ನ ವಿದ್ಯುತ್ ಮೂಲವನ್ನು ನಿಲ್ಲಿಸಿ.",
            "ಅಗತ್ಯವಿದ್ದರೆ ಒಣ, ವಿದ್ಯುತ್ ಹರಿಯದ ವಸ್ತು ಬಳಸಿ ದೂರ ಮಾಡಿ.",
            "ಉಸಿರಾಟ, ನಾಡಿ, ಜಾಗೃತಿ ಪರಿಶೀಲಿಸಿ.",
            "ಅಗತ್ಯವಿದ್ದರೆ CPR ಪ್ರಾರಂಭಿಸಿ ಮತ್ತು ತುರ್ತು ವೈದ್ಯಕೀಯ ನೆರವಿಗೆ ಕರೆ ಮಾಡಿ.",
            "ಕಾಣುವ ಸುಟ್ಟ ಗಾಯ ಮುಚ್ಚಿ ಹಾಗೂ ತಕ್ಷಣ ಆಸ್ಪತ್ರೆ ಪರೀಕ್ಷೆ ಮಾಡಿಸಿ.",
            dos = listOf(
                "ಮೊದಲು ಸ್ಥಳವು ವಿದ್ಯುತ್‌ರಹಿತವಾಗಿದೆಯೆ ಖಚಿತಪಡಿಸಿ.",
                "ಸಹಾಯ ಬರುವವರೆಗೂ ನಿರಂತರ ಗಮನಿಸಿ.",
                "ಪ್ರವೇಶ ಮತ್ತು ನಿರ್ಗಮನ ಸುಟ್ಟ ಗುರುತುಗಳನ್ನೂ ನೋಡಿ.",
                "ವ್ಯಕ್ತಿಯನ್ನು ಮಲಗಿಸಿ ಶಾಂತವಾಗಿರಿಸಿ.",
                "ಲಕ್ಷಣಗಳು ಸಣ್ಣದಾಗಿದ್ದರೂ ವೈದ್ಯರನ್ನು ಭೇಟಿ ಮಾಡಿ."
            ),
            donts = listOf(
                "ವಿದ್ಯುತ್ ಹರಿವು ಇರಬಹುದಾದಾಗ ನೇರವಾಗಿ ಮುಟ್ಟಬೇಡಿ.",
                "ಲೋಹ ಅಥವಾ ಒದ್ದೆಯಾದ ವಸ್ತು ಬಳಸದಿರಿ.",
                "ವಿದ್ಯುತ್ ಸುಟ್ಟ ಗಾಯಕ್ಕೆ ಮಲಹಂ ಹಚ್ಚಬೇಡಿ.",
                "ಸ್ಪೈನ್ ಗಾಯ ಶಂಕೆ ಇದ್ದರೆ ಅನಾವಶ್ಯಕ ಚಲನೆ ಮಾಡಬೇಡಿ.",
                "ನಂತರದ ಛಾತಿ ನೋವು/ಗೊಂದಲ ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ."
            )
        ),
        guide(
            "poisoning", "ವಿಷ ಸೇವನೆ", "#8D6E63",
            "ವಿಷದ ಪ್ರಕಾರ ಮತ್ತು ಪ್ರವೇಶ ಮಾರ್ಗ ಗುರುತಿಸಿ (ನುಂಗಿದ, ಉಸಿರಾಟ, ಚರ್ಮ, ಕಣ್ಣು).",
            "ತಕ್ಷಣ ವಿಷ ನಿಯಂತ್ರಣ ಕೇಂದ್ರ ಅಥವಾ ತುರ್ತು ಸೇವೆಗೆ ಕರೆ ಮಾಡಿ.",
            "ಅಜ್ಞಾನವಾಗಿದ್ದರೂ ಉಸಿರಾಟ ಇದ್ದರೆ ರಿಕವರಿ ಸ್ಥಿತಿಯಲ್ಲಿ ಇಡಿ.",
            "ರಾಸಾಯನಿಕ ಚರ್ಮ/ಕಣ್ಣಿಗೆ ಬಿದ್ದಿದ್ದರೆ 15-20 ನಿಮಿಷ ನೀರಿನಿಂದ ತೊಳೆಯಿರಿ.",
            "ಔಷಧಿ ಸ್ಟ್ರಿಪ್/ಕಂಟೇನರ್/ಫೋಟೋವನ್ನು ಆಸ್ಪತ್ರೆಗೆ ಕೊಂಡೊಯ್ಯಿ.",
            dos = listOf(
                "ಶ್ವಾಸಮಾರ್ಗ ತೆರವು ಇರಿಸಿ ಮತ್ತು ಉಸಿರಾಟ ಗಮನಿಸಿ.",
                "ಸಾಧ್ಯವಾದರೆ ಸಮಯ ಮತ್ತು ಪ್ರಮಾಣ ವಿವರ ಸಂಗ್ರಹಿಸಿ.",
                "ವಿಷ ತಜ್ಞರ ಸೂಚನೆಗಳನ್ನು ಕಟ್ಟುನಿಟ್ಟಾಗಿ ಅನುಸರಿಸಿ.",
                "ಸುರಕ್ಷಿತವಾಗಿದ್ದರೆ ಮಾದರಿಯನ್ನು ವೈದ್ಯರಿಗೆ ಉಳಿಸಿ.",
                "ಗಂಭೀರ ಲಕ್ಷಣ ಇದ್ದರೆ ವೇಗವಾಗಿ ಆಸ್ಪತ್ರೆಗೆ ಕರೆದೊಯ್ಯಿ."
            ),
            donts = listOf(
                "ಸೂಚನೆ ಇಲ್ಲದೆ ವಾಂತಿ ಮಾಡಿಸಬೇಡಿ.",
                "ಹಾಲು, ನಿಂಬೆ ಅಥವಾ ಮನೆಮದ್ದುಗಳನ್ನು ಅಜಾಗರೂಕವಾಗಿ ಕೊಡಬೇಡಿ.",
                "ಮಲಗುತಿರುವವರಿಗೆ ಬಲವಂತವಾಗಿ ದ್ರವ ಕೊಡಬೇಡಿ.",
                "ತುರ್ತು ಸಲಹೆ ಪಡೆಯುವುದನ್ನು ವಿಳಂಬಿಸಬೇಡಿ.",
                "ಮೌಲ್ಯಮಾಪನಕ್ಕೂ ಮೊದಲು ವಿಷದ ಬಾಟಲಿ ತ್ಯಜಿಸಬೇಡಿ."
            )
        ),
        guide(
            "fever", "ಜ್ವರ", "#66BB6A",
            "ತಾಪಮಾನ ಅಳೆದು ಇತರೆ ಲಕ್ಷಣಗಳನ್ನೂ ಪರಿಶೀಲಿಸಿ.",
            "ದ್ರವ ಪದಾರ್ಥಗಳು ಮತ್ತು ಸಮರ್ಪಕ ವಿಶ್ರಾಂತಿ ಕೊಡಿಸಿ.",
            "ವಯಸ್ಸಿಗೆ ತಕ್ಕ ಜ್ವರ ಔಷಧಿಯನ್ನು ಸಲಹೆಯಂತೆ ಬಳಸಿ.",
            "ಅಸೌಕರ್ಯ ಇದ್ದರೆ ಮೃದುವಾದ ನೀರಿನಿಂದ ಒರೆಸಿ.",
            "ಹೆಚ್ಚಿನ ಜ್ವರ ಮುಂದುವರಿದರೆ ಅಥವಾ ಎಚ್ಚರಿಕೆ ಲಕ್ಷಣ ಇದ್ದರೆ ವೈದ್ಯರನ್ನು ಭೇಟಿ ಮಾಡಿ.",
            dos = listOf(
                "ನೀರು/ORS ನೀಡಿ ದೇಹದ ನೀರಿನ ಸಮತೋಲನ ಕಾಪಾಡಿ.",
                "ಲಘು ಬಟ್ಟೆ ಹಾಕಿಸಿ ಮತ್ತು ಕೋಣೆ ಗಾಳಿ ಸರಾಗ ಇರಿಸಿ.",
                "ಮಕ್ಕಳು ಮತ್ತು ವಯೋವೃದ್ಧರನ್ನು ಗಮನಿಸಿ.",
                "ಜ್ವರ ಮಾದರಿ ಮತ್ತು ಇತರೆ ಲಕ್ಷಣ ದಾಖಲಿಸಿ.",
                "ಸೈಜರ್, ಹುಳುಪು ಅಥವಾ ಉಸಿರಾಟ ತೊಂದರೆ ಇದ್ದರೆ ತುರ್ತು ಚಿಕಿತ್ಸೆ ಪಡೆಯಿರಿ."
            ),
            donts = listOf(
                "ಭಾರಿ ಹೊದಿಕೆಗಳಲ್ಲಿ ಮರೆಸಬೇಡಿ.",
                "ಮಕ್ಕಳಿಗೆ ಆಸ್ಪಿರಿನ್ ಕೊಡಬೇಡಿ.",
                "ಪ್ರಿಸ್ಕ್ರಿಪ್ಷನ್ ಇಲ್ಲದೆ ಆಂಟಿಬಯೋಟಿಕ್ ಅತಿಯಾಗಿ ಬಳಸದಿರಿ.",
                "ಡಿಹೈಡ್ರೇಷನ್ ಲಕ್ಷಣಗಳನ್ನು ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ.",
                "ದೀರ್ಘಕಾಲ ಜ್ವರಕ್ಕೆ ವೈದ್ಯರ ಪರಿಶೀಲನೆ ವಿಳಂಬಿಸಬೇಡಿ."
            )
        ),
        guide(
            "bleeding", "ರಕ್ತಸ್ರಾವ", "#EC407A",
            "ಸ್ವಚ್ಛ ಬಟ್ಟೆ/ಪಟ್ಟಿಯಿಂದ ನೇರವಾಗಿ ಬಲ ಒತ್ತಡ ನೀಡಿ.",
            "ಮುರಿತ ಶಂಕೆ ಇಲ್ಲದಿದ್ದರೆ ಗಾಯಗೊಂಡ ಭಾಗವನ್ನು ಎತ್ತಿ ಇಡಿ.",
            "ಮೊದಲ ಪಟ್ಟಿಗೆ ರಕ್ತ ತೇವವಾದರೆ ಮತ್ತಷ್ಟು ಪದರ ಹಾಕಿ, ಒತ್ತಡ ಮುಂದುವರಿಸಿ.",
            "ರಕ್ತಸ್ರಾವ ನಿಯಂತ್ರಿತವಾದ ನಂತರ ಬಿಗಿಯಾಗಿ ಬ್ಯಾಂಡೇಜ್ ಮಾಡಿ.",
            "ಭಾರಿ ಅಥವಾ ನಿಲ್ಲದ ರಕ್ತಸ್ರಾವಕ್ಕೆ ತುರ್ತು ಸಹಾಯ ಕೋರಿರಿ.",
            dos = listOf(
                "ಸಾಧ್ಯವಾದರೆ ಗ್ಲೌಸ್ ಬಳಸಿ.",
                "ರೋಗಿಯನ್ನು ಮಲಗಿಸಿ ಬೆಚ್ಚಗೆ ಇಟ್ಟು ಶಾಕ್ ತಡೆಗಟ್ಟಿರಿ.",
                "ನಾಡಿ ಮತ್ತು ಜಾಗೃತಿ ಗಮನಿಸಿ.",
                "ಸಿಡಿದು ಬರುತ್ತಿರುವ ರಕ್ತಕ್ಕೆ ತಕ್ಷಣ ತುರ್ತು ಕರೆ ಮಾಡಿ.",
                "ತಜ್ಞರು ಬರೆಯುವವರೆಗೂ ಒತ್ತಡ ಬಿಡಬೇಡಿ."
            ),
            donts = listOf(
                "ಒಳಗೆ ಹೂರಿಕೊಂಡ ವಸ್ತುಗಳನ್ನು ತೆಗೆದುಹಾಕಬೇಡಿ.",
                "ಮೊದಲ ಪಟ್ಟಿಯನ್ನು ಮರುಮರು ಎತ್ತಿ ನೋಡುವುದಿಲ್ಲ.",
                "ತರಬೇತಿ ಇಲ್ಲದೆ ಟೂರ್‌ನಿಕೆಟ್ ಬಳಸದಿರಿ.",
                "ತೀವ್ರ ರಕ್ತನಷ್ಟದಲ್ಲಿ ಸಹಾಯ ವಿಳಂಬಿಸಬೇಡಿ.",
                "ಶಸ್ತ್ರಚಿಕಿತ್ಸೆ ಸಾಧ್ಯತೆ ಇದ್ದರೆ ಆಹಾರ ಕೊಡಬೇಡಿ."
            )
        ),
        guide(
            "eye_injury", "ಕಣ್ಣಿನ ಗಾಯ", "#42A5F5",
            "ಗಾಯಗೊಂಡ ಕಣ್ಣನ್ನು ಒರೆಸಬೇಡಿ ಅಥವಾ ಒತ್ತಬೇಡಿ.",
            "ರಾಸಾಯನಿಕ ಬಿದ್ದಿದ್ದರೆ ಕನಿಷ್ಠ 15 ನಿಮಿಷ ಸ್ವಚ್ಛ ನೀರಿನಿಂದ ತೊಳೆಯಿರಿ.",
            "ಸ್ವಚ್ಛ ಕಪ್/ಡ್ರೆಸ್ಸಿಂಗ್ ಬಳಸಿ ಕಣ್ಣನ್ನು ಹಗುರವಾಗಿ ರಕ್ಷಿಸಿ.",
            "ವಸ್ತು ಒಳಗೆ ನುಗ್ಗಿದ್ದರೆ ಎರಡೂ ಕಣ್ಣು ಚಲಿಸದಂತೆ ಮುಚ್ಚಿ.",
            "ತಕ್ಷಣ ಕಣ್ಣು ತಜ್ಞರ ಚಿಕಿತ್ಸೆ ಪಡೆಯಿರಿ.",
            dos = listOf(
                "ಸಹಾಯ ಮಾಡುವ ಮೊದಲು ಕೈ ತೊಳೆಯಿರಿ.",
                "ರೋಗಿಯನ್ನು ಶಾಂತವಾಗಿರಿಸಿ, ಕಣ್ಣಿನ ಚಲನೆ ಕಡಿಮೆ ಮಾಡಿ.",
                "ತಕ್ಷಣ ತಜ್ಞ ಚಿಕಿತ್ಸೆಗೆ ಕರೆದೊಯ್ಯಿ.",
                "ನೋವು ಇದ್ದರೆ ಹೆಚ್ಚು ಬೆಳಕಿನಿಂದ ರಕ್ಷಿಸಿ.",
                "ಕಾರಣವನ್ನು ಸ್ಪಷ್ಟವಾಗಿ ತಿಳಿಸಿ (ರಾಸಾಯನಿಕ/ಲೋಹ/ಆಘಾತ)."
            ),
            donts = listOf(
                "ಒಳಗೆ ಹೂರಿದ ವಸ್ತುವನ್ನು ತೆಗೆಯಬೇಡಿ.",
                "ಬಿಗಿಯಾದ ಒತ್ತಡ ಪ್ಯಾಚ್ ಹಾಕಬೇಡಿ.",
                "ವೈದ್ಯ ಸಲಹೆ ಇಲ್ಲದೆ ಕಣ್ಣು ಹನಿಗಳು ಬಳಸದಿರಿ.",
                "ದೃಷ್ಟಿ ಬದಲಾವಣೆ ಇದ್ದರೆ ಚಿಕಿತ್ಸೆ ವಿಳಂಬಿಸಬೇಡಿ.",
                "ಕಣ್ಣು ಒರೆಸಲು ಬಿಡಬೇಡಿ."
            )
        ),
        guide(
            "allergic_reaction", "ಅಲರ್ಜಿ ಪ್ರತಿಕ್ರಿಯೆ", "#7E57C2",
            "ತೀವ್ರ ಲಕ್ಷಣಗಳನ್ನು ಗುರುತಿಸಿ: ಉಬ್ಬರ, ಉಸಿರಾಟ ತೊಂದರೆ, ಊಸರು, ತಲೆಸುತ್ತು.",
            "ಅನಾಫೈಲಾಕ್ಸಿಸ್ ಶಂಕೆ ಇದ್ದರೆ ವೈದ್ಯರು ಸೂಚಿಸಿದ ಎಪಿನೆಫ್ರಿನ್ ತಕ್ಷಣ ನೀಡಿ.",
            "ತಕ್ಷಣ ತುರ್ತು ಸೇವೆಗೆ ಕರೆ ಮಾಡಿ.",
            "ತೀವ್ರ ಉಸಿರಾಟ ತೊಂದರೆ ಇಲ್ಲದಿದ್ದರೆ ಕಾಲು ಎತ್ತಿ ಮಲಗಿಸಿ.",
            "ಶ್ವಾಸಮಾರ್ಗ ಗಮನಿಸಿ ಮತ್ತು CPRಗೆ ಸಿದ್ಧರಿರಿ.",
            dos = listOf(
                "ಲಕ್ಷಣ ಉಳಿದರೆ ವೈದ್ಯರ ಸಲಹೆಯಂತೆ ಎಪಿನೆಫ್ರಿನ್ ಪುನಃ ನೀಡಿ.",
                "ಸಾಧ್ಯವಾದರೆ ಅಲರ್ಜಿ ಮೂಲದಿಂದ ದೂರ ಮಾಡಿ.",
                "ರೋಗಿಯನ್ನು ಗಮನದಲ್ಲಿಡಿ.",
                "ಆಸ್ಪತ್ರೆಗೆ ಅಲರ್ಜಿ ಇತಿಹಾಸ ಕೊಂಡೊಯ್ಯಿ.",
                "ಚೇತರಿಸಿಕೊಂಡರೂ ಆಸ್ಪತ್ರೆ ಪರಿಶೀಲನೆ ಮಾಡಿಸಿ."
            ),
            donts = listOf(
                "ತೀವ್ರ ಲಕ್ಷಣದಲ್ಲಿದ್ದು ಎಪಿನೆಫ್ರಿನ್ ನೀಡುವುದನ್ನು ವಿಳಂಬಿಸಬೇಡಿ.",
                "ರೋಗಿಯನ್ನು ಹಠಾತ್ ನಿಲ್ಲಿಸಿ ನಡೆಯಲು ಬಿಡಬೇಡಿ.",
                "ತೀವ್ರ ಪ್ರತಿಕ್ರಿಯೆಯಲ್ಲಿ ಆಹಾರ/ಪಾನೀಯ ಕೊಡಬೇಡಿ.",
                "ಒಬ್ಬರನ್ನೇ ಬಿಡಬೇಡಿ.",
                "ಅನಾಫೈಲಾಕ್ಸಿಸ್‌ನಲ್ಲಿ ಅಂಟಿಹಿಸ್ಟಮಿನ್ ಮಾತ್ರಕ್ಕೆ ಅವಲಂಬಿಸಬೇಡಿ."
            )
        ),
        guide(
            "fainting", "ಮೂರ್ಛೆ", "#26C6DA",
            "ವ್ಯಕ್ತಿಯನ್ನು ಸಾದವಾಗಿ ಮಲಗಿಸಿ ಕಾಲುಗಳನ್ನು 20-30 ಸೆಂ.ಮೀ ಎತ್ತಿ.",
            "ಬಿಗಿಯಾದ ಬಟ್ಟೆ ಸಡಿಲಿಸಿ ಮತ್ತು ಶುದ್ಧ ಗಾಳಿ ಒದಗಿಸಿ.",
            "ಉಸಿರಾಟ ಮತ್ತು ನಾಡಿ ಪರಿಶೀಲಿಸಿ.",
            "ವಾಂತಿ ಇದ್ದರೆ ಬದಿಗೆ ತಿರುಗಿಸಿ.",
            "ವೇಗವಾಗಿ ಚೇತರಿಸದಿದ್ದರೆ ವೈದ್ಯಕೀಯ ಸಹಾಯ ಪಡೆಯಿರಿ.",
            dos = listOf(
                "ಚೇತರಿಸಿಕೊಂಡ ಬಳಿಕ ಭರವಸೆ ನೀಡಿ.",
                "ಎದ್ದುಕೊಳ್ಳುವ ಮೊದಲು ಕೆಲವು ನಿಮಿಷ ವಿಶ್ರಾಂತಿ ಕೊಡಿಸಿ.",
                "ಪೂರ್ಣ ಎಚ್ಚರವಾದ ನಂತರ ದ್ರವ ನೀಡಿ.",
                "ಬೆಚ್ಚಗೆ/ಊಟ ಬಿಟ್ಟದ್ದು ಮುಂತಾದ ಟ್ರಿಗರ್‌ಗಳನ್ನು ಗಮನಿಸಿ.",
                "ಮರುಮರು ಘಟನೆಗಳಲ್ಲಿ ವೈದ್ಯ ಪರಿಶೀಲನೆ ಮಾಡಿಸಿ."
            ),
            donts = listOf(
                "ತಕ್ಷಣ ಎದ್ದು ನಿಲ್ಲಲು ಒತ್ತಾಯಿಸಬೇಡಿ.",
                "ತೀವ್ರವಾಗಿ ತಣ್ಣೀರು ಸಿಂಪಡಿಸಬೇಡಿ.",
                "ಅಜ್ಞಾನದ ವೇಳೆ ದ್ರವ ಕೊಡಬೇಡಿ.",
                "ಮೂರ್ಛೆಯೊಂದಿಗೆ ಛಾತಿ ನೋವು/ತಲೆಗಾಯ ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ.",
                "ಚೇತರಿಸಿಕೊಂಡ ತಕ್ಷಣ ಒಂಟಿಯಾಗಿ ಬಿಡಬೇಡಿ."
            )
        ),
        guide(
            "seizure", "ಅಕಸ್ಮಿಕ ವಿಕಾರ (ಸೈಜರ್)", "#D4E157",
            "ಅಪಾಯಕರ ವಸ್ತುಗಳನ್ನು ದೂರ ಮಾಡಿ ಗಾಯ ತಪ್ಪಿಸಿ.",
            "ತಲೆಯ ಕೆಳಗೆ ಮೃದುವಾದ ವಸ್ತು ಇಡಿ.",
            "ಚಲನೆಗಳನ್ನು ಹಿಡಿದು ನಿಲ್ಲಿಸಬೇಡಿ; ಸೈಜರ್ ಸ್ವತಃ ನಿಲ್ಲಲು ಬಿಡಿ.",
            "ಜರ್ಕಿಂಗ್ ನಿಂತ ಬಳಿಕ ರಿಕವರಿ ಸ್ಥಿತಿಯಲ್ಲಿ ಇಡಿ.",
            "ಸೈಜರ್ ಸಮಯ ದಾಖಲಿಸಿ; 5 ನಿಮಿಷಕ್ಕಿಂತ ಹೆಚ್ಚು ಇದ್ದರೆ ತುರ್ತು ಸಹಾಯ ಕೋರಿರಿ.",
            dos = listOf(
                "ಶಾಂತವಾಗಿರಿ ಮತ್ತು ರೋಗಿಯ ಜೊತೆಗೆ ಇರಿ.",
                "ಸೈಜರ್ ನಂತರ ಉಸಿರಾಟ ಪರಿಶೀಲಿಸಿ.",
                "ಕುತ್ತಿಗೆ ಸುತ್ತ ಬಿಗಿಯಾದ ಬಟ್ಟೆ ಸಡಿಲಿಸಿ.",
                "ಮೊದಲ ಬಾರಿಗೆ ಸೈಜರ್/ಗಾಯ ಇದ್ದರೆ ವೈದ್ಯ ಸಹಾಯ ಪಡೆಯಿರಿ.",
                "ಅವಧಿ ಮತ್ತು ಲಕ್ಷಣಗಳನ್ನು ವೈದ್ಯರಿಗೆ ದಾಖಲಿಸಿ."
            ),
            donts = listOf(
                "ಬಾಯಿಗೆ ಏನನ್ನೂ ಹಾಕಬೇಡಿ.",
                "ರೋಗಿಯನ್ನು ಬಲವಂತವಾಗಿ ಹಿಡಿದುಕೊಳ್ಳಬೇಡಿ.",
                "ಪೂರ್ಣ ಎಚ್ಚರವಾಗುವವರೆಗೂ ಆಹಾರ/ದ್ರವ/ಗೋಳಿ ಕೊಡಬೇಡಿ.",
                "ಚಿಕ್ಕ ಸೈಜರ್‌ಗೂ ಗಾಬರಿಯಾಗಬೇಡಿ.",
                "ದೀರ್ಘ ಗೊಂದಲವನ್ನು ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ."
            )
        ),
        guide(
            "nosebleed", "ಮೂಗಿನಿಂದ ರಕ್ತಸ್ರಾವ", "#FFCA28",
            "ವ್ಯಕ್ತಿಯನ್ನು ನೇರವಾಗಿ ಕುಳ್ಳಿರಿಸಿ ಮತ್ತು ಸ್ವಲ್ಪ ಮುಂದೆ ವಾಲಿಸಿ.",
            "ಮೂಗಿನ ಮೃದುವಾದ ಭಾಗವನ್ನು 10-15 ನಿಮಿಷ ನಿರಂತರವಾಗಿ ಒತ್ತಿ ಹಿಡಿಯಿರಿ.",
            "ಮೂಗಿನ ಮೇಲೆ ತಣ್ಣೀರು/ಕೋಲ್ಡ್ ಕಂಪ್ರೆಸ್ ಹಚ್ಚಿ.",
            "ಅಗತ್ಯವಿದ್ದರೆ ಇನ್ನೂ 10 ನಿಮಿಷ ಒತ್ತಡ ಮುಂದುವರಿಸಿ.",
            "ರಕ್ತಸ್ರಾವ ನಿಲ್ಲದಿದ್ದರೆ ಅಥವಾ ಮರುಕಳಿಸಿದರೆ ವೈದ್ಯರನ್ನು ಸಂಪರ್ಕಿಸಿ.",
            dos = listOf(
                "ಒತ್ತಿದಾಗ ಬಾಯಿಯಿಂದ ಉಸಿರಾಡಲು ಹೇಳಿ.",
                "ರಕ್ತವನ್ನು ನುಂಗದೆ ಉಗುಳಲು ಹೇಳಿ.",
                "ರಕ್ತ ನಿಂತ ನಂತರ ಶಾಂತವಾಗಿ ವಿಶ್ರಾಂತಿ ಕೊಡಿಸಿ.",
                "ಬ್ಲಡ್ ಥಿನ್ನರ್ ಬಳಕೆದಾರರಿಗೆ ವೈದ್ಯರ ಸಲಹೆ ಪಡೆಯಿರಿ.",
                "ಒಣ ವಾತಾವರಣದಲ್ಲಿ ತೇವಾಂಶ ಕಾಪಾಡಿ."
            ),
            donts = listOf(
                "ತಲೆಯನ್ನು ಹಿಂದೆ ಜೋಕು ಮಾಡಬೇಡಿ.",
                "ರಕ್ತ ನಿಂತ ತಕ್ಷಣ ಮೂಗು ಊದಬೇಡಿ/ಕುರೆಯಬೇಡಿ.",
                "ಸಕ್ರಿಯ ರಕ್ತಸ್ರಾವದಲ್ಲಿ ಮಲಗಿಸಬೇಡಿ.",
                "ಒತ್ತಡವನ್ನು ಬೇಗ ಬಿಡಬೇಡಿ.",
                "ಮುಖಗಾಯದ ನಂತರದ ರಕ್ತಸ್ರಾವ ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ."
            )
        ),
        guide(
            "sprain", "ಮುರಿ/ಮೆತ್ತಗಾಯ (Sprain)", "#9CCC65",
            "ಗಾಯಗೊಂಡ ಸಂಧಿಗೆ ವಿಶ್ರಾಂತಿ ನೀಡಿ ಮತ್ತು ಚಟುವಟಿಕೆ ನಿಲ್ಲಿಸಿ.",
            "ಬಟ್ಟೆಯಲ್ಲಿ ಸುತ್ತಿದ ಐಸ್ ಪ್ಯಾಕ್ 15-20 ನಿಮಿಷ ಅನೇಕ ಬಾರಿ ಹಚ್ಚಿ.",
            "ಬೆಂಬಲಕ್ಕಾಗಿ ಕಾಂಪ್ರೆಶನ್ ಬ್ಯಾಂಡೇಜ್ ಬಳಸಿ.",
            "ಅಂಗವನ್ನು ಹೃದಯ ಮಟ್ಟಕ್ಕಿಂತ ಮೇಲೆ ಎತ್ತಿ ಇಡಿ.",
            "ತೀವ್ರ ಉಬ್ಬರ/ವಿಕೃತಿ ಅಥವಾ ತೂಕ ಹಾಕಲಾಗದಿದ್ದರೆ ವೈದ್ಯಕೀಯ ಸೇವೆ ಪಡೆಯಿರಿ.",
            dos = listOf(
                "ಮೊದಲ 24-48 ಗಂಟೆ RICE ವಿಧಾನ ಅನುಸರಿಸಿ.",
                "ಉಬ್ಬರವಿರುವ ಅಂಗದ ಉಂಗುರಗಳನ್ನು ಬೇಗ ತೆಗೆದುಹಾಕಿ.",
                "ಅಗತ್ಯವಿದ್ದರೆ ಬೆಂಬಲ ಬ್ರೇಸ್ ಬಳಸಿ.",
                "ನೋವು ಕಡಿಮೆಯಾದ ಮೇಲೆ ನಿಧಾನ ಚಲನೆ ಪ್ರಾರಂಭಿಸಿ.",
                "ತೀವ್ರ ನೋವಿದ್ದರೆ ಮುರಿತ ಪರೀಕ್ಷೆ ಮಾಡಿಸಿ."
            ),
            donts = listOf(
                "ಮೊದಲ 48 ಗಂಟೆ ನೇರ ಉಷ್ಣತೆ ಕೊಡಬೇಡಿ.",
                "ತೀವ್ರ ಗಾಯದ ತಕ್ಷಣ ಮಸಾಜ್ ಮಾಡಬೇಡಿ.",
                "ಕ್ರೀಡೆಗೆ ಬೇಗ ಮರಳಬೇಡಿ.",
                "ಸ್ಥಿರತೆಯ ಸಮಸ್ಯೆ ಮುಂದುವರಿದರೆ ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ.",
                "ಕಾಂಪ್ರೆಶನ್ ತುಂಬಾ ಬಿಗಿಯಾಗಿ ಕಟ್ಟಬೇಡಿ."
            )
        ),
        guide(
            "dog_bite", "ನಾಯಿ ಕಚ್ಚು", "#8D6E63",
            "ಗಾಯವನ್ನು ಸಾಬೂನು ಮತ್ತು ಹರಿಯುವ ನೀರಿನಿಂದ 10-15 ನಿಮಿಷ ಚೆನ್ನಾಗಿ ತೊಳೆಯಿರಿ.",
            "ಆಂಟಿಸೆಪ್ಟಿಕ್ ಹಾಕಿ ಸ್ವಚ್ಛ ಪಟ್ಟಿಯಿಂದ ಮುಚ್ಚಿ.",
            "ಸಾಧಾರಣ ನೇರ ಒತ್ತಡದಿಂದ ರಕ್ತಸ್ರಾವ ನಿಯಂತ್ರಿಸಿ.",
            "ರೇಬೀಸ್ ಅಪಾಯ ಮತ್ತು ಟೆಟನಸ್ ರಕ್ಷಣೆಗೆ ತಕ್ಷಣ ವೈದ್ಯರನ್ನು ಭೇಟಿ ಮಾಡಿ.",
            "ಗಾಯದಲ್ಲಿ ಸೋಂಕು ಲಕ್ಷಣಗಳಿಗಾಗಿ ದಿನವೂ ಗಮನಿಸಿ.",
            dos = listOf(
                "ಸಣ್ಣ ರಂಧ್ರ ಗಾಯಕ್ಕೂ ವೈದ್ಯಕೀಯ ಪರಿಶೀಲನೆ ಮಾಡಿಸಿ.",
                "ಸಾಧ್ಯವಾದರೆ ನಾಯಿಯ ವಿವರ/ಲಸಿಕೆ ಮಾಹಿತಿ ದಾಖಲಿಸಿ.",
                "ಗಾಯವನ್ನು ಸ್ವಚ್ಛ ಮತ್ತು ಒಣವಾಗಿ ಇಡಿ.",
                "ನೀಡಿದ ಲಸಿಕೆ/ಚಿಕಿತ್ಸಾ ಕೋರ್ಸ್ ಪೂರ್ಣಗೊಳಿಸಿ.",
                "ಜ್ವರ, ಕೆಂಪು, ಉಬ್ಬರ ಹೆಚ್ಚಾದರೆ ತಕ್ಷಣ ಮರಳಿ ಭೇಟಿ ಮಾಡಿ."
            ),
            donts = listOf(
                "ಸಣ್ಣದಂತೆ ಕಂಡರೂ ಕಚ್ಚನ್ನು ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ.",
                "ಆಳವಾದ ಕೆಸರಿನ ಗಾಯವನ್ನು ಮನೆಯಲ್ಲೇ ಹೊಯ್ದುಕೊಳ್ಳಬೇಡಿ.",
                "ರೇಬೀಸ್ ಚಿಕಿತ್ಸೆ ಮಧ್ಯದಲ್ಲಿ ನಿಲ್ಲಿಸಬೇಡಿ.",
                "ಪೌಡರ್/ಪೇಸ್ಟ್ ಹಚ್ಚಬೇಡಿ.",
                "ರಸ್ತೆ ನಾಯಿಯ ಕಚ್ಚಿಗೆ ಚಿಕಿತ್ಸೆ ವಿಳಂಬಿಸಬೇಡಿ."
            )
        ),
        guide(
            "head_injury", "ತಲೆಗಾಯ", "#78909C",
            "ಮೊದಲು ಪ್ರತಿಕ್ರಿಯೆ ಮತ್ತು ಉಸಿರಾಟ ಪರಿಶೀಲಿಸಿ.",
            "ತಲೆ ಮತ್ತು ಕುತ್ತಿಗೆಯನ್ನು ಸರಿಯಾಗಿ ಇರಿಸಿ, ಚಲನೆ ಕಡಿಮೆ ಮಾಡಿ.",
            "ಸಣ್ಣ ಉಬ್ಬರಿಗೆ ಬಟ್ಟೆಯಲ್ಲಿ ಸುತ್ತಿದ ತಣ್ಣೀರು ಪ್ಯಾಕ್ ಹಚ್ಚಿ.",
            "ವಾಂತಿ, ತೀವ್ರ ತಲೆನೋವು, ಗೊಂದಲ, ಮಂಕು ಲಕ್ಷಣಗಳನ್ನು ಗಮನಿಸಿ.",
            "ಅಜ್ಞಾನ, ಸೈಜರ್, ದುರ್ಬಲತೆ ಅಥವಾ ಲಕ್ಷಣ ವೃದ್ಧಿ ಇದ್ದರೆ ತುರ್ತು ಕರೆ ಮಾಡಿ.",
            dos = listOf(
                "24 ಗಂಟೆಗಳ ಕಾಲ ಗಮನದಲ್ಲಿಡಿ.",
                "ಮಕ್ಕಳು ಮತ್ತು ವಯೋವೃದ್ಧರಿಗೆ ತಕ್ಷಣ ವೈದ್ಯಕೀಯ ಪರಿಶೀಲನೆ ಮಾಡಿಸಿ.",
                "ಸಣ್ಣ ಗಾಯದ ಬಳಿಕ ನಿಯಮಿತವಾಗಿ ಜಾಗೃತಿ ಪರಿಶೀಲಿಸಿ.",
                "ತೀವ್ರ ಗಾಯಕ್ಕೆ ಆಂಬ್ಯುಲೆನ್ಸ್ ಮೂಲಕ ಕರೆದೊಯ್ಯಿ.",
                "ಬ್ಲಡ್ ಥಿನ್ನರ್ ಬಳಕೆ ಮಾಹಿತಿ ವೈದ್ಯರಿಗೆ ತಿಳಿಸಿ."
            ),
            donts = listOf(
                "ವ್ಯಕ್ತಿಯನ್ನು ಕದಡಬೇಡಿ.",
                "ತಕ್ಷಣ ಕ್ರೀಡೆ/ಭಾರಿ ಕೆಲಸಕ್ಕೆ ಬಿಡಬೇಡಿ.",
                "ಮದ್ಯ ಅಥವಾ ಮಂಕು ಔಷಧಿ ಕೊಡಬೇಡಿ.",
                "ಪುನರಾವರ್ತಿತ ವಾಂತಿಯನ್ನು ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ.",
                "ಸ್ಪೈನ್ ಗಾಯ ಶಂಕೆ ಇದ್ದರೆ ಅಪಾಯವಿಲ್ಲದೆ ಕದಲಿಸಬೇಡಿ."
            )
        ),
        guide(
            "asthma_attack", "ಆಸ್ತಮಾ ದಾಳಿ", "#42A5F5",
            "ವ್ಯಕ್ತಿಯನ್ನು ನೇರವಾಗಿ ಕುಳ್ಳಿರಿಸಿ ಮತ್ತು ಧೈರ್ಯ ನೀಡಿ.",
            "ಸಾಧ್ಯವಿದ್ದರೆ ಸ್ಪೇಸರ್ ಜೊತೆಗೆ ರಿಲೀವರ್ ಇನ್ಹೇಲರ್ ಬಳಕೆ ಸಹಾಯ ಮಾಡಿ.",
            "ಆಸ್ತಮಾ ಯೋಜನೆಯಂತೆ ಪಫ್‌ಗಳನ್ನು ಪುನರಾವರ್ತಿಸಿ.",
            "ಲಕ್ಷಣ ಬೇಗ ಕಡಿಮೆಯಾಗದಿದ್ದರೆ ತುರ್ತು ಸಹಾಯಕ್ಕೆ ಕರೆ ಮಾಡಿ.",
            "ಉಸಿರಾಟ, ಮಾತು, ಜಾಗೃತಿ ನಿರಂತರವಾಗಿ ಗಮನಿಸಿ.",
            dos = listOf(
                "ರಿಲೀವರ್ ಇನ್ಹೇಲರ್ ಹತ್ತಿರ ಇಡಿ.",
                "ಔಷಧಿ ಪರಿಣಾಮ ಹೆಚ್ಚಲು ಸ್ಪೇಸರ್ ಬಳಸಿ.",
                "ಬಿಗಿ ಬಟ್ಟೆ ಸಡಿಲಿಸಿ.",
                "ವೈಯಕ್ತಿಕ ಆಸ್ತಮಾ ಯೋಜನೆ ಅನುಸರಿಸಿ.",
                "ತೀವ್ರ ದಾಳಿಯ ನಂತರ ವೈದ್ಯಕೀಯ ಪರಿಶೀಲನೆ ಮಾಡಿಸಿ."
            ),
            donts = listOf(
                "ವ್ಯಕ್ತಿಯನ್ನು ಮಲಗಿಸಬೇಡಿ.",
                "ತೀವ್ರ ಉಸಿರಾಟ ತೊಂದರೆಯಲ್ಲಿ ತುರ್ತು ಕರೆ ವಿಳಂಬಿಸಬೇಡಿ.",
                "ಒಬ್ಬರನ್ನೇ ಬಿಡಬೇಡಿ.",
                "ಉಸಿರಾಟ ಕಷ್ಟವಾಗುವಾಗ ಆಹಾರ/ಪಾನೀಯ ಬಲವಂತ ಮಾಡಬೇಡಿ.",
                "ನೀಲ ತುಟಿ ಅಥವಾ ಮಾತು ಆಗದಿರುವುದನ್ನು ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ."
            )
        ),
        guide(
            "diabetic_emergency", "ಮಧುಮೇಹ ತುರ್ತು ಪರಿಸ್ಥಿತಿ", "#F06292",
            "ಪ್ರತಿಕ್ರಿಯೆ ಮತ್ತು ಸಾಧ್ಯವಿದ್ದರೆ ರಕ್ತದಲ್ಲಿನ ಸಕ್ಕರೆ ಪರಿಶೀಲಿಸಿ.",
            "ಜಾಗೃತಿಯಿದ್ದರೆ ಮತ್ತು ಲೋ ಶುಗರ್ ಶಂಕೆ ಇದ್ದರೆ ತಕ್ಷಣ ಸಕ್ಕರೆ (ಗ್ಲೂಕೋಸ್/ಜ್ಯೂಸ್) ನೀಡಿ.",
            "10-15 ನಿಮಿಷದ ನಂತರ ಮರುಪರಿಶೀಲಿಸಿ, ಅಗತ್ಯವಿದ್ದರೆ ಮತ್ತೆ ಸಕ್ಕರೆ ನೀಡಿ.",
            "ಚೇತರಿಕೆಯ ನಂತರ ದೀರ್ಘ ಪರಿಣಾಮದ ಸಣ್ಣ ತಿಂಡಿ ನೀಡಿ.",
            "ಅಜ್ಞಾನ, ಸೈಜರ್ ಅಥವಾ ಸುಧಾರಣೆ ಇಲ್ಲದಿದ್ದರೆ ತುರ್ತು ಸಹಾಯ ಕೋರಿರಿ.",
            dos = listOf(
                "ಮಧುಮೇಹಿಗಳಿಗೆ ಸಕ್ಕರೆ ಮೂಲವನ್ನು ತಯಾರಾಗಿ ಇಡಿ.",
                "ಮತ್ತೆ ಲಕ್ಷಣಗಳಿಗಾಗಿ ಗಮನಿಸಿ.",
                "ಮಧುಮೇಹ ಗುರುತು/ಮಾಹಿತಿ ಲಭ್ಯವಾಗಿರಲಿ.",
                "ಅಜ್ಞಾನದಲ್ಲಿದ್ದರೆ ರಿಕವರಿ ಸ್ಥಿತಿಯಲ್ಲಿ ಇಡಿ.",
                "ತೀವ್ರ ಘಟನೆಯಲ್ಲಿ ತಕ್ಷಣ ಆಸ್ಪತ್ರೆ ಮೌಲ್ಯಮಾಪನ ಮಾಡಿಸಿ."
            ),
            donts = listOf(
                "ಅಜ್ಞಾನಸ್ಥಿತಿಯಲ್ಲಿ ಆಹಾರ/ಪಾನೀಯ ಕೊಡಬೇಡಿ.",
                "ಲೋ ಶುಗರ್ ಶಂಕೆಯಲ್ಲಿ ಇನ್ಸುಲಿನ್ ಇಂಜೆಕ್ಷನ್ ಕೊಡಬೇಡಿ.",
                "ಗೊಂದಲ/ಸೈಜರ್‌ನಲ್ಲಿ ತುರ್ತು ಸಹಾಯ ವಿಳಂಬಿಸಬೇಡಿ.",
                "ತಾತ್ಕಾಲಿಕ ಸುಧಾರಣೆಯ ನಂತರ ಒಬ್ಬರನ್ನೇ ಬಿಡಬೇಡಿ.",
                "ಪುನಃಪುನಃ ಲೋ ಶುಗರ್ ಲಕ್ಷಣಗಳನ್ನು ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ."
            )
        )
    )

    private val hospitalsEnglish = listOf(
        Hospital("Manipal Hospital", "98, HAL Airport Road, Bengaluru", "+91 80402 21000"),
        Hospital("Aster CMI Hospital", "43/2, New Airport Road, Hebbal, Bengaluru", "+91 80434 20100"),
        Hospital("Narayana Health City", "258/A, Bommasandra Industrial Area, Bengaluru", "+91 80468 33333")
    )

    private val hospitalsKannada = listOf(
        Hospital("ಮಣಿಪಾಲ್ ಆಸ್ಪತ್ರೆ", "98, HAL ಏರ್‌ಪೋರ್ಟ್ ರಸ್ತೆ, ಬೆಂಗಳೂರು", "+91 80402 21000"),
        Hospital("ಅಸ್ಟರ್ CMI ಆಸ್ಪತ್ರೆ", "43/2, ನ್ಯೂ ಏರ್‌ಪೋರ್ಟ್ ರಸ್ತೆ, ಹೆಬ್ಬಾಳ, ಬೆಂಗಳೂರು", "+91 80434 20100"),
        Hospital("ನಾರಾಯಣ ಹೆಲ್ತ್ ಸಿಟಿ", "258/A, ಬೊಮ್ಮಸಂದ್ರ ಇಂಡಸ್ಟ್ರಿಯಲ್ ಏರಿಯಾ, ಬೆಂಗಳೂರು", "+91 80468 33333")
    )

    fun getEmergencyGuides(language: AppLanguage): List<EmergencyGuide> {
        return if (language == AppLanguage.KANNADA) emergencyGuidesKannada else emergencyGuidesEnglish
    }

    fun getEmergencyGuideById(id: String, language: AppLanguage): EmergencyGuide? {
        return getEmergencyGuides(language).find { it.id == id }
    }

    fun getHospitals(language: AppLanguage): List<Hospital> {
        return if (language == AppLanguage.KANNADA) hospitalsKannada else hospitalsEnglish
    }

    private fun guide(
        id: String,
        title: String,
        colorHex: String,
        vararg steps: String,
        dos: List<String>,
        donts: List<String>
    ): EmergencyGuide {
        return EmergencyGuide(
            id = id,
            title = title,
            steps = steps.toList(),
            dos = dos,
            donts = donts,
            tileColorHex = colorHex
        )
    }
}
